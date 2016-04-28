package Controller;

/**
 * Created by Henrik on 2016-04-28.
 */
public class MainGuiController {
    private boolean turIsChecked;
    private boolean returIsChecked;


    public void turIsChecked(){
        this.turIsChecked = true;
        this.returIsChecked = false;

    }
    public void returIsChecked(){
        this.turIsChecked = false;
        this.returIsChecked = true;
    }



}
