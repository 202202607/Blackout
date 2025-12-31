import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.Container;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class remember extends JFrame {

    public class key implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            System.out.println("Key pressed: " + KeyEvent.getKeyText(keyCode) + " - Key code: " + keyCode);
            switch (keyCode) {
                case 27:
                    System.exit(0);
                    break;
                case 116:   //F5
                    Mousexy();
                    break;
                case 117:   //F6
                    Mousemove();
                    Mouseclick();
                default:
                    break;
            }
        }

        public void keyReleased(KeyEvent e) {
            //int keyCode = e.getKeyCode();
            //System.out.println("Key released: " + KeyEvent.getKeyText(keyCode));
        }

        public void keyTyped(KeyEvent e) {
            // Not used
        }
        
    }

    public void Make() {
        setTitle("/ㅡ/");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //윈도우 창 종료시 프로세스까지 닫기

        Container c = getContentPane();
        c.addKeyListener(new key());
        c.setFocusable(true);
        setSize(200, 200);
        setVisible(true);

    }

    public void Mousemove(){
        try{
            Robot robot=new Robot();
            robot.mouseMove(mousex, mousey);
            Thread.sleep(100);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void Mouseclick(){
        try{
            Robot robot=new Robot();
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(100);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void Mousexy(){
        Point point = MouseInfo.getPointerInfo().getLocation();
        mousex=(int)point.getLocation().getX();
        mousey=(int)point.getLocation().getY();
        System.out.println("x :" + mousex);
        System.out.println("y :" + mousey);
    }

    public int mousex = 0;
    public int mousey = 0;

    public static void main(String[] args) throws Exception {
        try{
            remember wewillbewatching = new remember();
            wewillbewatching.Make();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
