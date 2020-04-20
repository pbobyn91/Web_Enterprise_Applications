/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boby0003;

import java.awt.Color;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * This class is a Color Converter, so it takes in either a String or a Color Object and it converts it into an Object or a String, respectively.
 * 
 * @author Pat
 */

@FacesConverter("colorConverter")
@RequestScoped
public class ColorConverter implements Converter {

    /**
     * This method takes in a String and Converts it into a Color.
     * 
     * @param context 
     * @param component
     * @param value The string value to be converted into a Color
     * @return Returns a Color Object
     */
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       
        if (value == null) {
            return null;
        }   
        
        if (value.matches("#[0-9A-Fa-f]{6}")){
            Color color = new Color(Integer.parseInt(value.substring(1), 16));
            return color;
        } else {
            throw new ConverterException("Color Format is #123456");
        }
    }
    
    /**
     * This method converts a Color object into string format
     * 
     * @param facesContext
     * @param component
     * @param object The object that is to be converted into a string
     * @return Returns a String format of the object
     */
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Color) {
                                          
            return String.format("#%02X%02X%02X", ((Color)object).getRed(), ((Color)object).getGreen(), ((Color)object).getBlue());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Color.class.getName());
        }
    }
}
