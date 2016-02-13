
package lingosphere2;
import javax.swing.*;;
import java.awt.* ;

public class LingoSphere2 extends JPanel{  
    public LingoSphere2() {
        
    super(new GridLayout(1,1));
    
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP) ;
    LoginPage mainPage    = new LoginPage();
    TranslatePage xLate = new TranslatePage() ;
    SelfTestPage lessonPlan = new SelfTestPage();
    GradedTestPage gradedTest = new GradedTestPage();
    TeacherPage teacherPage = new TeacherPage() ;
    
    tabbedPane.addTab("Welcome", mainPage.buildLoginGui());
    tabbedPane.addTab("Lesson Plan", xLate.buildXlateGui());
    tabbedPane.addTab("Self Test", lessonPlan.buildSelfTestGui());
    tabbedPane.addTab("Graded Test", gradedTest.buildGradedTestGui());
    tabbedPane.addTab("TeacherPage",teacherPage);
    add(tabbedPane);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tabbed GUI");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       frame.add(new LingoSphere2(),BorderLayout.CENTER);
       
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
}