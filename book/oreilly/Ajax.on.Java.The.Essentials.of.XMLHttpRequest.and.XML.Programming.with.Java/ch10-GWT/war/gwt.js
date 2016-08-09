// Copyright 2006 Google Inc. All Rights Reserved.
// This startup script should be included in host pages.
//

//////////////////////////////////////////////////////////////////
// Common
//
var __GWT_JS_INCLUDED;

if (!__GWT_JS_INCLUDED) {
  __GWT_JS_INCLUDED = true;

var __gwt_retryWaitMs = 50;
var __gwt_moduleNames = [];
var __gwt_isHostPageLoaded = false;
var __gwt_metaProps = {};
var __gwt_onPropertyError = null;
var __gwt_onLoadError = null;

function __gwt_isHosted() {
  if (window.external && window.external.gwtOnLoad) {
    if (document.location.href.indexOf("gwt.hybrid") == -1) {
      return true;
    }
  }
  return false;
}

function __gwt_processMetas() {
  var metas = document.getElementsByTagName("meta");
  for (var i = 0, n = metas.length; i < n; ++i) {
    var meta = metas[i];
    var name = meta.getAttribute("name");
    if (name) {
      if (name == "gwt:module") {
        var content = meta.getAttribute("content");
        if (content) {
          __gwt_moduleNames = __gwt_moduleNames.concat(content);
        }
      } else if (name == "gwt:property") {
        var content = meta.getAttribute("content");
        if (content) {
          var name = content, value = "";
          var eq = content.indexOf("=");
          if (eq != -1) {
            name = content.substring(0, eq);
            value = content.substring(eq+1);
          }
          __gwt_metaProps[name] = value;
        }
      } else if (name == "gwt:onPropertyErrorFn") {
        var content = meta.getAttribute("content");
        if (content) {
          try {
            __gwt_onPropertyError = eval(content);
          } catch (e) {
            window.alert("Bad handler \"" + content + "\" for \"gwt:onPropertyErrorFn\"");
          }
        }
      } else if (name == "gwt:onLoadErrorFn") {
        var content = meta.getAttribute("content");
        if (content) {
          try {
            __gwt_onLoadError = eval(content);
          } catch (e) {
            window.alert("Bad handler \"" + content + "\" for \"gwt:onLoadErrorFn\"");
          }
        }
      }
    }
  }
}

function __gwt_getMetaProperty(name) {
  var value = __gwt_metaProps[name];
  if (value) {
    return value;
  } else {
    return null;
  }
}

function __gwt_forEachModule(lambda) {
  for (var i = 0; i < __gwt_moduleNames.length; ++i) {
    lambda(__gwt_moduleNames[i]);
  }
}

// Called by the selection script when a property has a bad value or is missing.
// 'allowedValues' is an array of strings.
// Can be hooked in the host page.
//
function __gwt_onBadProperty(moduleName, propName, allowedValues, badValue) {
  if (__gwt_onPropertyError) {
    __gwt_onPropertyError(moduleName, propName, allowedValues, badValue);
    return;
  } else {
    var msg = "While attempting to load module \"" + moduleName + "\", ";
    if (badValue != null) {
       msg += "property \"" + propName + "\" was set to the unexpected value \"" + badValue + "\"";
    } else {
       msg += "property \"" + propName + "\" was not specified";
    }
    
   msg += "\n\nAllowed values: " + allowedValues;
   
    window.alert(msg);
  }
}

// Returns an array that splits the module name from the meta content into
// [0] the prefix url, if any, guaranteed to end with a slash
// [1] the dotted module name
//
function __gwt_splitModuleNameRef(moduleName) {
   var parts = ['', moduleName];
   var i = moduleName.lastIndexOf("=");
   if (i != -1) {
      parts[0] = moduleName.substring(0, i) + '/';
      parts[1] = moduleName.substring(i+1);
   }
   return parts;
}

//////////////////////////////////////////////////////////////////
// Called directly from compiled code
//
function __gwt_initHandlers(resize, beforeunload, unload) {
   var oldOnResize = window.onresize;
   window.onresize = function() {
      resize();
      if (oldOnResize)
         oldOnResize();
   };

   var oldOnBeforeUnload = window.onbeforeunload;
   window.onbeforeunload = function() {
      var ret = beforeunload();

      var oldRet;
      if (oldOnBeforeUnload)
        oldRet = oldOnBeforeUnload();

      if (ret !== null)
        return ret;
      return oldRet;
   };

   var oldOnUnload = window.onunload;
   window.onunload = function() {
      unload();
      if (oldOnUnload)
         oldOnUnload();
   };
}

//////////////////////////////////////////////////////////////////
// Web Mode
//
function __gwt_injectWebModeFrame(name) {
   if (document.body) {
      var parts = __gwt_splitModuleNameRef(name);
   
      // Insert an IFRAME
      var iframe = document.createElement("iframe");
      var selectorURL = parts[0] + parts[1] + ".nocache.html";
      iframe.src = selectorURL;
      iframe.style.border = '0px';
      iframe.style.width = '0px';
      iframe.style.height = '0px';
      if (document.body.firstChild) {
         document.body.insertBefore(iframe, document.body.firstChild);
      } else {
         document.body.appendChild(iframe);
      }
   } else {
      // Try again in a moment.
      //
      window.setTimeout(function() { __gwt_injectWebModeFrame(name); }, __gwt_retryWaitMs);
   }
}

// When nested IFRAMEs load, they reach up into the parent page to announce that
// they are ready to run. Because IFRAMEs load asynchronously relative to the 
// host page, one of two things can happen when they reach up:
// (1) The host page's onload handler has not yet been called, in which case we 
//     retry until it has been called.
// (2) The host page's onload handler has already been called, in which case the
//     nested IFRAME should be initialized immediately.
//
function __gwt_webModeFrameOnLoad(iframeWindow, name) {
  var moduleInitFn = iframeWindow.gwtOnLoad;
  if (__gwt_isHostPageLoaded && moduleInitFn) {
    var old = window.status;
    window.status = "Initializing module '" + name + "'";
    try {
        moduleInitFn(__gwt_onLoadError, name);
    } finally {
        window.status = old;
    }
  } else {
    setTimeout(function() { __gwt_webModeFrameOnLoad(iframeWindow, name); }, __gwt_retryWaitMs);
  }
}

function __gwt_hookOnLoad() {
  var oldHandler = window.onload;
  window.onload = function() {
    __gwt_isHostPageLoaded = true;
    if (oldHandler) {
      oldHandler();
    }
  };
}

//////////////////////////////////////////////////////////////////
// Hosted Mode
//
function __gwt_injectHostedModeFrame(name) {
  if (document.body) {
    // Insert an empty IFRAME
    var iframe = document.createElement("iframe");
    iframe.style.display = "none";
    document.body.insertBefore(iframe, document.body.firstChild);
    iframe.src = "gwt-hosted.html?" + name;
  } else {
    // Try again in a moment.
    //
    window.setTimeout(function() { __gwt_injectHostedModeFrame(name); }, __gwt_retryWaitMs);
  }
}

function __gwt_initHostedModeModule(moduleFrame, moduleName) {
    if (!window.external.gwtOnLoad(moduleFrame, moduleName)) {
        // Module failed to load.
        //
        if (__gwt_onLoadError) {
            __gwt_onLoadError(moduleName);
        } else {
            window.alert("Failed to load module '" + moduleName + "'.\nPlease see the log in the development shell for details.");
        }
    }
}

function __gwt_onUnload() {
    window.external.gwtOnLoad(null, null);
    if (__gwt_onUnload.oldUnloadHandler) {
        __gwt_onUnload.oldUnloadHandler();
    }
}

//////////////////////////////////////////////////////////////////
// Set it up
//
__gwt_processMetas();

if (__gwt_isHosted()) {
  __gwt_onUnload.oldUnloadHandler = window.onunload;
  window.onunload = __gwt_onUnload;
  __gwt_forEachModule(__gwt_injectHostedModeFrame);
}
else {
  __gwt_hookOnLoad();
  __gwt_forEachModule(__gwt_injectWebModeFrame);
}

} // __GWT_JS_INCLUDED
