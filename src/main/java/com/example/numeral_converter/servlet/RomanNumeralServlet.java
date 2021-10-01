package com.example.numeral_converter.servlet;

import com.example.numeral_converter.external.RomanNumeralConverterException;
import com.example.numeral_converter.entity.RomanNumeralConverter;;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

@WebServlet(name = "RomanNumeral", value = "/romannumeral")
public class RomanNumeralServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(RomanNumeralServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get roman numeral from request URL.
        String number = request.getParameter("query");
        //Let the client know the returned data is in JSON format.
        response.setContentType("application/json");
        JSONObject responseObject = new JSONObject();

        try {
            // Return the roman number if input is provided in the request URL, otherwise return exception to user
            if (number != null) {

                LOGGER.info("Input: " + number );
                String roman = RomanNumeralConverter.numToRoman(number);
                LOGGER.info("Output: " + roman );
                responseObject.put("input", number);
                responseObject.put("output", roman);
                response.getWriter().print(responseObject);
            } else {
                responseObject.put("Error", "Invalid input format");
                response.getWriter().print(responseObject);
            }
        } catch (RomanNumeralConverterException e) {
            //log warning message if exception is thrown
            String errorMsg = e.getMessage();
            LOGGER.warning(errorMsg);
            responseObject.put("Error", errorMsg);
            response.getWriter().print(responseObject);
        } catch (Exception e){
            //log warning message if exception is thrown
            String errorMsg = e.getMessage();
            LOGGER.warning(errorMsg);
            responseObject.put("Error", errorMsg);
            response.getWriter().print(responseObject);
            throw new ServletException(e);
        }
    }
}