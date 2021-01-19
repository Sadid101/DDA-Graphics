import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;

public class DDA implements GLEventListener{
   
	private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      
    //drawing 8
      
      DDA(gl, 1,1,1,20);
      DDA(gl, 1,1,6,1);
      DDA(gl, 6,1,6,20);
      DDA(gl, 1,20,6,20);
      DDA(gl, 1,10,6,10);
      
    //drawing 3
      
      DDA(gl, 8,1,13,1);
      DDA(gl, 13,1,13,20);
      DDA(gl, 8,20,13,20);
      DDA(gl, 8,10,13,10);
      
      
      
   }
   @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }
   
   @Override
   public void init(GLAutoDrawable gld) {
       GL2 gl = gld.getGL().getGL2();
       glu = new GLU();

       gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
       gl.glViewport(-100, -50, 50, 100);
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
       glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
   }

   

   @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   
   
   public void DDA(GL2 gl, float x1, float y1, float x2, float y2) {
       
       gl.glPointSize(3.0f);
       gl.glColor3d(1, 0, 0);
       float dx=x2-x1;
       float dy=y2-y1;
       float steps=0;
       if(dy>dx){
           steps=dy;
       }
       else{
           steps=dx;
       }
       float yinc=dy/steps;
       System.out.println(yinc);
       float xinc=dx/steps;
       System.out.println(xinc);
       System.out.println("x1 "+x1);
       System.out.println("x2 "+x2);
       System.out.println("y1 "+y1);
       System.out.println("y2 "+y2);
       gl.glBegin(GL2.GL_POINTS);
       float div=0.8f;
       gl.glVertex3f(x1/div, y1/div, 0); //initial point
       if(steps==dy){
           while(y1!=y2){
           x1=x1+xinc;
           System.out.println("x1 "+x1);
           y1=y1+yinc;
           System.out.println("y1 "+y1);
           gl.glVertex3f(x1/div, y1/div, 0);
           }
       }
       if(steps==dx){
           while(x1!=x2){
           x1=x1+xinc;
           System.out.println("x1 "+x1);
           y1=y1+yinc;
           System.out.println("y1 "+y1);
           gl.glVertex3f(x1/div, y1/div, 0);
           }
       }
          
       gl.glEnd();
}

   
   
   
   
   
   public static void main(String[] args) {
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
      // The canvas 
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      DDA l = new DDA();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(400, 400);
      //creating frame
      final JFrame frame = new JFrame ("straight Line");
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
   }//end of main
}//end of classimport javax.media.opengl.GL2;