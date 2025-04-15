/*Testing url: https://the-internet.herokuapp.com/dynamic_controls
       Test the following:
       ** Remove/Add section
        - Remove button should be displayed
            - xpath: //button[text()='Remove']], //button[text()='Add']
            - css: button:nth-child(1)
        - Checkbox: by default, it is unchecked
            - id: checkbox
            - xpath: //input[@id='checkbox']
            - css: #checkbox
        - A message make clear the state of the checkbox.
            - default: using the getText() method
            - id: message
            - xpath: //p[text()="It's gone!"], //p[text()="It's back!"]
            - css: #message
        - Checking the Remove/Add button
            At the first time clicking on the Remove button:
                1. The progress bar displays: it is still in the DOM but not visible
                - id: loading
                - xpath: //div[@id='loading']
                - css: #loading
            Clicking on the add button:
                1. The progress bar disappears
                2. in the <br> tag, the progress bar in its
                3. the message should be displayed
                4. the checkbox should be displayed below the message

        2. The Remove button should be the add button
        3. The checkbox should be removed
        4. A message make clear the state of the checkbox

       ** Enable/Disable section
        - A field displayed but unable to interact with it
        - Enable button should be displayed
        - A message make clear the state of the field


* */
package heroku;

public class DynamicControls {
}
