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
            if(keyCode == 27){
                System.exit(0);
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

    public void Mousemove(int x, int y, Robot robot){
        try{
            robot.mouseMove(x, y);
            Thread.sleep(100);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void Mouseclick(Robot robot){
        try{
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(100);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int[] Mousexy(){
        Point point = MouseInfo.getPointerInfo().getLocation();
        int[] xyArray= new int[2];
        xyArray[0]=(int)point.getLocation().getX();
        xyArray[1]=(int)point.getLocation().getY();
        return xyArray;
    }


    public static void main(String[] args) throws Exception {
        try{
            Robot robot=new Robot();
            remember wewillbewatching = new remember();
            wewillbewatching.Make();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}