package hjapp.com.umeng.fb;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
{
  public static int a(Date paramDate1, Date paramDate2)
  {
    if (paramDate1.after(paramDate2));
    while (true)
    {
      long l = paramDate2.getTime();
      return (int)((paramDate1.getTime() - l) / 1000L);
      Date localDate = paramDate2;
      paramDate2 = paramDate1;
      paramDate1 = localDate;
    }
  }

  public static String a()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }

  public static String a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("channel"))
        paramJSONObject.put("channel", URLEncoder.encode(paramJSONObject.getString("channel"), "UTF-8"));
      return paramJSONObject.toString();
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public static Date a(String paramString)
  {
    try
    {
      Date localDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString);
      return localDate;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static void a(Context paramContext)
  {
    Toast.makeText(paramContext, paramContext.getString(hjapp.com.umeng.fb.b.e.A(paramContext)), 0).show();
  }

  public static void a(Context paramContext, Date paramDate)
  {
    Editor localEditor = paramContext.getSharedPreferences("exchange_last_request_time", 0).edit();
    localEditor.putString("last_request_time", hjapp.com.umeng.common.b.a(paramDate));
    localEditor.commit();
  }

  public static String b(JSONObject paramJSONObject)
  {
    while (true)
    {
      int j;
      int i;
      try
      {
        JSONObject localJSONObject1 = paramJSONObject.optJSONObject("header");
        if (localJSONObject1 != null)
        {
          if (localJSONObject1.has("access_subtype"))
            localJSONObject1.put("access_subtype", URLEncoder.encode(localJSONObject1.getString("access_subtype"), "UTF-8"));
          if (localJSONObject1.has("cpu"))
            localJSONObject1.put("cpu", URLEncoder.encode(localJSONObject1.getString("cpu"), "UTF-8"));
          if (localJSONObject1.has("app_version"))
            localJSONObject1.put("app_version", URLEncoder.encode(localJSONObject1.getString("app_version"), "UTF-8"));
          if (localJSONObject1.has("country"))
            localJSONObject1.put("country", URLEncoder.encode(localJSONObject1.getString("country"), "UTF-8"));
          if (localJSONObject1.has("device_model"))
            localJSONObject1.put("device_model", URLEncoder.encode(localJSONObject1.getString("device_model"), "UTF-8"));
          if (localJSONObject1.has("carrier"))
            localJSONObject1.put("carrier", URLEncoder.encode(localJSONObject1.getString("carrier"), "UTF-8"));
          if (localJSONObject1.has("language"))
            localJSONObject1.put("language", URLEncoder.encode(localJSONObject1.getString("language"), "UTF-8"));
          if (localJSONObject1.has("channel"))
            localJSONObject1.put("channel", URLEncoder.encode(localJSONObject1.getString("channel"), "UTF-8"));
        }
        JSONObject localJSONObject2 = paramJSONObject.optJSONObject("body");
        JSONArray localJSONArray1 = localJSONObject2.optJSONArray("event");
        if (localJSONArray1 != null)
        {
          j = 0;
          if (j < localJSONArray1.length())
          {
            JSONObject localJSONObject4 = localJSONArray1.optJSONObject(j);
            if (localJSONObject4 == null)
              break label423;
            if (localJSONObject4.has("label"))
              localJSONObject4.put("label", URLEncoder.encode(localJSONObject4.getString("label")));
            if (!localJSONObject4.has("tag"))
              break label423;
            localJSONObject4.put("tag", URLEncoder.encode(localJSONObject4.getString("tag")));
            break label423;
          }
        }
        JSONArray localJSONArray2 = localJSONObject2.optJSONArray("error");
        i = 0;
        if ((localJSONArray2 != null) && (i < localJSONArray2.length()))
        {
          JSONObject localJSONObject3 = localJSONArray2.optJSONObject(i);
          if ((localJSONObject3 == null) || (!localJSONObject3.has("context")))
            break label429;
          localJSONObject3.put("context", URLEncoder.encode(localJSONObject3.getString("context")));
          break label429;
        }
        String str = paramJSONObject.toString();
        return str;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramJSONObject.toString();
      }
      label423: j++;
      continue;
      label429: i++;
    }
  }

  public static Date b(Context paramContext)
  {
    return a(paramContext.getSharedPreferences("exchange_last_request_time", 0).getString("last_request_time", "1900-01-01 00:00:00"));
  }

  // ERROR //
  public static JSONObject c(Context paramContext)
  {
    // Byte code:
    //   0: new 42	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 184	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: ldc 186
    //   11: invokevirtual 190	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   14: checkcast 192	android/telephony/TelephonyManager
    //   17: astore 4
    //   19: aload_0
    //   20: invokestatic 196	com/umeng/common/b:d	(Landroid/content/Context;)Ljava/lang/String;
    //   23: astore 5
    //   25: aload 5
    //   27: ifnull +13 -> 40
    //   30: aload 5
    //   32: ldc 198
    //   34: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +20 -> 57
    //   40: getstatic 210	com/umeng/fb/f:h	Z
    //   43: ifeq +856 -> 899
    //   46: ldc 212
    //   48: ldc 214
    //   50: invokestatic 220	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   53: pop
    //   54: goto +845 -> 899
    //   57: aload_1
    //   58: ldc 222
    //   60: aload_0
    //   61: invokestatic 224	com/umeng/common/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   64: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload_1
    //   69: ldc 226
    //   71: aload 5
    //   73: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload_1
    //   78: ldc 141
    //   80: getstatic 232	android/os/Build:MODEL	Ljava/lang/String;
    //   83: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload_0
    //   88: invokestatic 235	com/umeng/common/b:k	(Landroid/content/Context;)Ljava/lang/String;
    //   91: astore 10
    //   93: aload 10
    //   95: ifnonnull +20 -> 115
    //   98: getstatic 210	com/umeng/fb/f:h	Z
    //   101: ifeq +800 -> 901
    //   104: ldc 212
    //   106: ldc 237
    //   108: invokestatic 220	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   111: pop
    //   112: goto +789 -> 901
    //   115: aload_1
    //   116: ldc 239
    //   118: aload 10
    //   120: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: pop
    //   124: getstatic 242	com/umeng/fb/f:m	Ljava/lang/String;
    //   127: ifnull +369 -> 496
    //   130: getstatic 242	com/umeng/fb/f:m	Ljava/lang/String;
    //   133: astore 13
    //   135: aload_1
    //   136: ldc 40
    //   138: aload 13
    //   140: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_0
    //   145: invokevirtual 246	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   148: aload_0
    //   149: invokevirtual 249	android/content/Context:getPackageName	()Ljava/lang/String;
    //   152: iconst_0
    //   153: invokevirtual 255	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   156: astore 65
    //   158: aload 65
    //   160: getfield 260	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   163: astore 66
    //   165: aload 65
    //   167: getfield 264	android/content/pm/PackageInfo:versionCode	I
    //   170: istore 67
    //   172: aload_1
    //   173: ldc 137
    //   175: aload 66
    //   177: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   180: pop
    //   181: aload_1
    //   182: ldc_w 266
    //   185: iload 67
    //   187: invokevirtual 269	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_1
    //   192: ldc_w 271
    //   195: ldc_w 273
    //   198: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload_1
    //   203: ldc_w 275
    //   206: ldc_w 277
    //   209: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload_1
    //   214: ldc_w 279
    //   217: ldc_w 273
    //   220: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   223: pop
    //   224: aload_1
    //   225: ldc_w 281
    //   228: getstatic 286	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   231: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   234: pop
    //   235: new 288	android/content/res/Configuration
    //   238: dup
    //   239: invokespecial 289	android/content/res/Configuration:<init>	()V
    //   242: astore 22
    //   244: aload_0
    //   245: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   248: aload 22
    //   250: invokestatic 299	android/provider/Settings$System:getConfiguration	(Landroid/content/ContentResolver;Landroid/content/res/Configuration;)V
    //   253: aload 22
    //   255: getfield 303	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   258: ifnull +341 -> 599
    //   261: aload_1
    //   262: ldc 139
    //   264: aload 22
    //   266: getfield 303	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   269: invokevirtual 308	java/util/Locale:getCountry	()Ljava/lang/String;
    //   272: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   275: pop
    //   276: aload_1
    //   277: ldc 145
    //   279: aload 22
    //   281: getfield 303	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   284: invokevirtual 309	java/util/Locale:toString	()Ljava/lang/String;
    //   287: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload 22
    //   293: getfield 303	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   296: invokestatic 315	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   299: astore 59
    //   301: aload 59
    //   303: ifnull +283 -> 586
    //   306: aload 59
    //   308: invokevirtual 319	java/util/Calendar:getTimeZone	()Ljava/util/TimeZone;
    //   311: astore 60
    //   313: aload 60
    //   315: ifnull +258 -> 573
    //   318: aload_1
    //   319: ldc_w 321
    //   322: aload 60
    //   324: invokevirtual 326	java/util/TimeZone:getRawOffset	()I
    //   327: ldc_w 327
    //   330: idiv
    //   331: invokevirtual 269	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   334: pop
    //   335: new 329	android/util/DisplayMetrics
    //   338: dup
    //   339: invokespecial 330	android/util/DisplayMetrics:<init>	()V
    //   342: astore 31
    //   344: aload_0
    //   345: ldc_w 332
    //   348: invokevirtual 190	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   351: checkcast 334	android/view/WindowManager
    //   354: invokeinterface 338 1 0
    //   359: aload 31
    //   361: invokevirtual 344	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   364: aload 31
    //   366: getfield 347	android/util/DisplayMetrics:widthPixels	I
    //   369: istore 47
    //   371: aload 31
    //   373: getfield 350	android/util/DisplayMetrics:heightPixels	I
    //   376: istore 48
    //   378: aload_1
    //   379: ldc_w 352
    //   382: new 354	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   389: iload 48
    //   391: invokestatic 358	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   394: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 364
    //   400: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: iload 47
    //   405: invokestatic 358	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   408: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 365	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload_0
    //   419: invokestatic 368	com/umeng/common/b:e	(Landroid/content/Context;)[Ljava/lang/String;
    //   422: astore 43
    //   424: aload_1
    //   425: ldc_w 370
    //   428: aload 43
    //   430: iconst_0
    //   431: aaload
    //   432: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   435: pop
    //   436: aload 43
    //   438: iconst_0
    //   439: aaload
    //   440: ldc_w 372
    //   443: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   446: ifeq +14 -> 460
    //   449: aload_1
    //   450: ldc 133
    //   452: aload 43
    //   454: iconst_1
    //   455: aaload
    //   456: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   459: pop
    //   460: aload_1
    //   461: ldc 143
    //   463: aload 4
    //   465: invokevirtual 375	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   468: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   471: pop
    //   472: aload_1
    //   473: ldc 135
    //   475: invokestatic 377	com/umeng/common/b:a	()Ljava/lang/String;
    //   478: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   481: pop
    //   482: aload_1
    //   483: ldc_w 379
    //   486: aload_0
    //   487: invokevirtual 249	android/content/Context:getPackageName	()Ljava/lang/String;
    //   490: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   493: pop
    //   494: aload_1
    //   495: areturn
    //   496: aload_0
    //   497: invokestatic 382	com/umeng/common/b:o	(Landroid/content/Context;)Ljava/lang/String;
    //   500: astore 13
    //   502: goto -367 -> 135
    //   505: astore 15
    //   507: getstatic 210	com/umeng/fb/f:h	Z
    //   510: ifeq +17 -> 527
    //   513: ldc 212
    //   515: ldc_w 384
    //   518: invokestatic 387	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   521: pop
    //   522: aload 15
    //   524: invokevirtual 388	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   527: aload_1
    //   528: ldc 137
    //   530: ldc_w 390
    //   533: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   536: pop
    //   537: aload_1
    //   538: ldc_w 266
    //   541: ldc_w 390
    //   544: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   547: pop
    //   548: goto -357 -> 191
    //   551: astore_2
    //   552: getstatic 210	com/umeng/fb/f:h	Z
    //   555: ifeq +16 -> 571
    //   558: ldc 212
    //   560: ldc_w 392
    //   563: invokestatic 220	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   566: pop
    //   567: aload_2
    //   568: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   571: aconst_null
    //   572: areturn
    //   573: aload_1
    //   574: ldc_w 321
    //   577: bipush 8
    //   579: invokevirtual 269	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   582: pop
    //   583: goto -248 -> 335
    //   586: aload_1
    //   587: ldc_w 321
    //   590: bipush 8
    //   592: invokevirtual 269	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   595: pop
    //   596: goto -261 -> 335
    //   599: invokestatic 396	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   602: astore 23
    //   604: getstatic 399	com/umeng/fb/f:l	Z
    //   607: ifeq +152 -> 759
    //   610: aload 23
    //   612: ifnull +147 -> 759
    //   615: aload 23
    //   617: invokevirtual 308	java/util/Locale:getCountry	()Ljava/lang/String;
    //   620: astore 24
    //   622: aload 24
    //   624: invokestatic 405	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   627: ifne +80 -> 707
    //   630: aload_1
    //   631: ldc 139
    //   633: aload 24
    //   635: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   638: pop
    //   639: aload 23
    //   641: invokevirtual 408	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   644: astore 26
    //   646: aload 26
    //   648: invokestatic 405	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   651: ifne +69 -> 720
    //   654: aload_1
    //   655: ldc 145
    //   657: aload 26
    //   659: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   662: pop
    //   663: aload 23
    //   665: invokestatic 315	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   668: astore 28
    //   670: aload 28
    //   672: ifnull +74 -> 746
    //   675: aload 28
    //   677: invokevirtual 319	java/util/Calendar:getTimeZone	()Ljava/util/TimeZone;
    //   680: astore 29
    //   682: aload 29
    //   684: ifnull +49 -> 733
    //   687: aload_1
    //   688: ldc_w 321
    //   691: aload 29
    //   693: invokevirtual 326	java/util/TimeZone:getRawOffset	()I
    //   696: ldc_w 327
    //   699: idiv
    //   700: invokevirtual 269	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   703: pop
    //   704: goto -369 -> 335
    //   707: aload_1
    //   708: ldc 139
    //   710: ldc_w 410
    //   713: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   716: pop
    //   717: goto -78 -> 639
    //   720: aload_1
    //   721: ldc 145
    //   723: ldc_w 410
    //   726: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   729: pop
    //   730: goto -67 -> 663
    //   733: aload_1
    //   734: ldc_w 321
    //   737: bipush 8
    //   739: invokevirtual 269	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   742: pop
    //   743: goto -408 -> 335
    //   746: aload_1
    //   747: ldc_w 321
    //   750: bipush 8
    //   752: invokevirtual 269	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   755: pop
    //   756: goto -421 -> 335
    //   759: aload_1
    //   760: ldc 139
    //   762: ldc_w 410
    //   765: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   768: pop
    //   769: aload_1
    //   770: ldc 145
    //   772: ldc_w 410
    //   775: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   778: pop
    //   779: aload_1
    //   780: ldc_w 321
    //   783: bipush 8
    //   785: invokevirtual 269	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   788: pop
    //   789: goto -454 -> 335
    //   792: astore 32
    //   794: getstatic 210	com/umeng/fb/f:h	Z
    //   797: ifeq +17 -> 814
    //   800: ldc 212
    //   802: ldc_w 412
    //   805: invokestatic 220	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   808: pop
    //   809: aload 32
    //   811: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   814: aload_1
    //   815: ldc_w 352
    //   818: ldc_w 410
    //   821: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   824: pop
    //   825: goto -407 -> 418
    //   828: astore 34
    //   830: getstatic 210	com/umeng/fb/f:h	Z
    //   833: ifeq +17 -> 850
    //   836: ldc 212
    //   838: ldc_w 414
    //   841: invokestatic 387	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   844: pop
    //   845: aload 34
    //   847: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   850: aload_1
    //   851: ldc_w 370
    //   854: ldc_w 410
    //   857: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   860: pop
    //   861: goto -401 -> 460
    //   864: astore 36
    //   866: getstatic 210	com/umeng/fb/f:h	Z
    //   869: ifeq +17 -> 886
    //   872: ldc 212
    //   874: ldc_w 416
    //   877: invokestatic 387	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   880: pop
    //   881: aload 36
    //   883: invokevirtual 68	java/lang/Exception:printStackTrace	()V
    //   886: aload_1
    //   887: ldc 143
    //   889: ldc_w 410
    //   892: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   895: pop
    //   896: goto -424 -> 472
    //   899: aconst_null
    //   900: areturn
    //   901: aconst_null
    //   902: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   144	191	505	android/content/pm/PackageManager$NameNotFoundException
    //   8	25	551	java/lang/Exception
    //   30	40	551	java/lang/Exception
    //   40	54	551	java/lang/Exception
    //   57	93	551	java/lang/Exception
    //   98	112	551	java/lang/Exception
    //   115	135	551	java/lang/Exception
    //   135	144	551	java/lang/Exception
    //   144	191	551	java/lang/Exception
    //   191	301	551	java/lang/Exception
    //   306	313	551	java/lang/Exception
    //   318	335	551	java/lang/Exception
    //   472	494	551	java/lang/Exception
    //   496	502	551	java/lang/Exception
    //   507	527	551	java/lang/Exception
    //   527	548	551	java/lang/Exception
    //   573	583	551	java/lang/Exception
    //   586	596	551	java/lang/Exception
    //   599	610	551	java/lang/Exception
    //   615	639	551	java/lang/Exception
    //   639	663	551	java/lang/Exception
    //   663	670	551	java/lang/Exception
    //   675	682	551	java/lang/Exception
    //   687	704	551	java/lang/Exception
    //   707	717	551	java/lang/Exception
    //   720	730	551	java/lang/Exception
    //   733	743	551	java/lang/Exception
    //   746	756	551	java/lang/Exception
    //   759	789	551	java/lang/Exception
    //   794	814	551	java/lang/Exception
    //   814	825	551	java/lang/Exception
    //   830	850	551	java/lang/Exception
    //   850	861	551	java/lang/Exception
    //   866	886	551	java/lang/Exception
    //   886	896	551	java/lang/Exception
    //   335	418	792	java/lang/Exception
    //   418	460	828	java/lang/Exception
    //   460	472	864	java/lang/Exception
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     g
 * JD-Core Version:    0.6.2
 */