import javax.swing.*;
import java.util.*;

class Burbuja{
  JLabel lblBurbujas[] = new JLabel[5];
  ArrayList<Integer> numeros = new ArrayList<>(5);
  
  int i=0;
  public Burbuja(JLabel burbujas[], int array[]){
    this.lblBurbujas[0]=burbujas[0];
    this.lblBurbujas[1]=burbujas[1];
    this.lblBurbujas[2]=burbujas[2];
    this.lblBurbujas[3]=burbujas[3];
    this.lblBurbujas[4]=burbujas[4];
    ArrayList<String> lista = new ArrayList<>();
    lista.add("./Imagenes/Burbuja18.png");
    lista.add("./Imagenes/Burbuja28.png");
    lista.add("./Imagenes/Burbuja35.png");
    lista.add("./Imagenes/Burbuja45.png");
    lista.add("./Imagenes/Burbuja72.png");
    ArrayList<Integer> datos = new ArrayList<>();
    datos.add(18);
    datos.add(28);
    datos.add(35);
    datos.add(45);
    datos.add(72);

    for(int i=0; i<5; i++) {
      numeros.add(i);
    }
    Random random = new Random();
    while(i<5){
      int randomIndex = random.nextInt(numeros.size());
      lblBurbujas[i].setIcon(new ImageIcon(((new ImageIcon(lista.get(randomIndex))).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
      array[i]=datos.get(randomIndex);
      numeros.remove(randomIndex);
      lista.remove(randomIndex);
      datos.remove(randomIndex);
      i++;
    }
  }
}
