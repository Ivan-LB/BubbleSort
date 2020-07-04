import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Burbujita extends JFrame implements ActionListener{
  JPanel panel;
  JLabel lblBurbujas[] = new JLabel[5];
  int numeros[] = new int[5];
  JButton btnRandom;
  JButton btnOrdenar;

  public Burbujita(){
    // this.add(panel);
    this.setTitle(" Bubble Sort ");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());

    JLabel background=new JLabel(new ImageIcon("./Imagenes/Fondo.png"));
    this.add(background);
    background.setLayout(null);
    // panel = new JPanel();
    // panel.setLayout(null);
    for (int i=0, x=120, y=300; i<lblBurbujas.length; i++, x+=150) {
      lblBurbujas[i] = new JLabel("Hola");
      lblBurbujas[i].setBounds(x,y,150,150);
      // panel.add(lblBurbujas[i]);
      background.add(lblBurbujas[i]);

    }
    btnOrdenar = new JButton("  Ordenar  ");
    btnOrdenar.setBounds(550,10,300,100);
    btnOrdenar.setFont(new Font("Serif", Font.PLAIN, 36));
    btnOrdenar.addActionListener(this);

    btnRandom = new JButton("   Revolver numeros  ");
    btnRandom.setBounds(120,10,375,100);
    btnRandom.setFont(new Font("Serif", Font.PLAIN, 36));
    btnRandom.addActionListener(this);

    // panel.add(btnRandom);panel.add(btnOrdenar);
    background.add(btnRandom);background.add(btnOrdenar);

    Burbuja b = new Burbuja(lblBurbujas,numeros);


  }
  public void actionPerformed(ActionEvent event){
    if (event.getSource() == this.btnRandom){
      Burbuja bj = new Burbuja(lblBurbujas,numeros);
    }
    if (event.getSource() == this.btnOrdenar){
      ordenar();
    }
  }
  public void ordenar(){
    new BurbujaWorker().execute();
  }
  public class BurbujaWorker extends SwingWorker<Void, Void> {
    int SPEED = 4; //velocidad de animacion (milisegundos)
    @Override
    public Void doInBackground() throws Exception {
      for(int i=0;i<lblBurbujas.length-1;i++){
        for(int j=0;j<lblBurbujas.length-i-1;j++){
          if(numeros[j]>numeros[j+1]){
              JLabel aux=lblBurbujas[j];
              int temp = numeros[j];
              numeros[j] = numeros[j+1];
              numeros[j+1]=temp;
              //animar movimiento
              girar(j,j+1);
              lblBurbujas[j]=lblBurbujas[j+1];
              lblBurbujas[j+1]=aux;
          }

        }
      }
      return null;
    }
    public void girar(int a , int b){
        //movmiento vertical
        Point pos1;
        Point pos2;
	      int x1;
        int x2;
	      int y1;
        int y2;
        for(int i=0; i<150;i++){
            pos1 = lblBurbujas[a].getLocation();
            x1 = (int)pos1.getX();
            y1 = (int)pos1.getY();

            pos2 = lblBurbujas[b].getLocation();
            x2 = (int)pos2.getX();
            y2 = (int)pos2.getY();

            //lblBurbujas[a].y -= 1;
            y1 -= 1;
            //lblBurbujas[b].y += 1;
            y2 += 1;
            try {
                Thread.sleep(SPEED);
             } catch (InterruptedException e) {}
               lblBurbujas[a].setLocation(x1,y1);
               lblBurbujas[b].setLocation(x2,y2);
        }
        //vomiento horizontal
        for(int i=0; i< 150;i++){
            pos1 = lblBurbujas[a].getLocation();
            x1 = (int)pos1.getX();
            y1 = (int)pos1.getY();

            pos2 = lblBurbujas[b].getLocation();
            x2 = (int)pos2.getX();
            y2 = (int)pos2.getY();
             //lblBurbujasa].x += 1;
             x1 +=1;

             //lblByurbujas[b].x -= 1;
             x2 -=1;
             try {
                Thread.sleep(SPEED);
             } catch (InterruptedException e) {}
            lblBurbujas[a].setLocation(x1,y1);
            lblBurbujas[b].setLocation(x2,y2);
        }

        //movimiento vertical
        for(int i=0; i< 150;i++){
          pos1 = lblBurbujas[a].getLocation();
          x1 = (int)pos1.getX();
          y1 = (int)pos1.getY();

          pos2 = lblBurbujas[b].getLocation();
          x2 = (int)pos2.getX();
          y2 = (int)pos2.getY();
            //lblBurbujas[a].y += 1;
            y1 += 1;
            //lblBurbujas[b].y -= 1;
            y2 -= 1;
            try {
                Thread.sleep(SPEED);
             } catch (InterruptedException e) {}
               lblBurbujas[a].setLocation(x1,y1);
               lblBurbujas[b].setLocation(x2,y2);
        }
    }
  }
}
