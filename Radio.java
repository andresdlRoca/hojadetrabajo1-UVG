/******************************************************************
Radio.java
Autores: Andrés de la Roca (20332) y Sebastian Aristondo ()
Última modificación: 


******************************************************************/
import java.text.DecimalFormat;

public class Radio implements InterfazRadio {

//Intancia de atributos
//-----------------------------
int [] EmisorasAM;
float [] EmisorasFM;
float frecuencuaFM = 87.9f;
int frecuencuaAM = 530;
boolean estado;
boolean AMFM;
//------------------------------
DecimalFormat df = new DecimalFormat("#.#");
//df.setRoundingMode(RoundingMode.CEILING);

  public Radio()
  {
    estado =false;
    AMFM = false;//Am = falso / Fm=true;
    EmisorasAM = new int[12];
    EmisorasFM = new float[12];
    //frecuencuaAM=530;
    //frecuencuaFM=87.9;
  }


  public void encender()
  {
    estado=true;
  }

  public void apagar()
  {
    estado=false;
  }
  
  public boolean isON()
  {
    return estado;
  }
  //  Distribución de responsabilidad, la función unicamente se encarga de llamar al metodo según la frecuencia
  public void incrementar()
  {
    
    if(AMFM)
    {
      incrementarFM();
    }
    else
    {
      incrementarAM();
    }

    
  }

  private void incrementarAM()
  {
    frecuencuaAM+=10;
    if(frecuencuaAM>1610)
    {
      frecuencuaAM=530;
    }
    System.out.println(frecuencuaAM);
  }

  private void incrementarFM()
  {
    frecuencuaFM+=0.2f;
    
    if(frecuencuaFM>107.9f)
    {
      frecuencuaFM=87.9f;
    }
    System.out.println(df.format(frecuencuaFM));
  }
  //  Distribución de responsabilidad, la función unicamente se encarga de llamar al metodo según la frecuencia
  public void disminuir()
  {
    
    if(AMFM)
    {
      disminuirFM();
    }
    else
    {
      disminuirAM();
    }

        
  }

  private void disminuirAM()
  {
    frecuencuaAM-=10;
    if(frecuencuaAM<530)
    {
     frecuencuaAM=1610;
    }
  System.out.println(frecuencuaAM);
  }

  private void disminuirFM()
  {
    frecuencuaFM-=0.2f;
    if(frecuencuaFM<87.9f)
    {
      frecuencuaFM=107.9f;
    }
    System.out.println(df.format(frecuencuaFM));
  }

  public void asignar(int pos)
  {
    if(AMFM)
    {//FM
      EmisorasFM[pos-1]=frecuencuaFM;
    }
    else
    {//AM
      EmisorasAM[pos-1]=frecuencuaAM;
    }
  }

  public void emisoras(int pos)
  {
    if(AMFM)
    {//FM
      System.out.println(EmisorasFM[pos-1]+"");
    }
    else
    {//AM
      System.out.println(EmisorasAM[pos-1]+"");
    }
  }
  
  public void frecuencias()
  {
    AMFM=!AMFM;
  }


  
}