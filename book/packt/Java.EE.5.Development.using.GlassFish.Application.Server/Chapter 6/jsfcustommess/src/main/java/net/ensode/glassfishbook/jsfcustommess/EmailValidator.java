package net.ensode.glassfishbook.jsfcustommess;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator
{

  public void validate(FacesContext facesContext, UIComponent uiComponent,
      Object value) throws ValidatorException
  {
    org.apache.commons.validator.EmailValidator emailValidator = org.apache.commons.validator.EmailValidator
        .getInstance();
    HtmlInputText htmlInputText = (HtmlInputText) uiComponent;

    if (!emailValidator.isValid((String) value))
    {
      FacesMessage facesMessage = new FacesMessage(htmlInputText.getLabel()
          + ": email format is not valid");
      throw new ValidatorException(facesMessage);
    }
  }

}
