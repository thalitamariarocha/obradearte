import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Teste {
public static void main(String[] args) {

EntityManagerFactory factory = Persistence.createEntityManagerFactory("Galeria_ArtePU");
EntityManager em = factory.createEntityManager();
        ObraDeArte obra = new ObraDeArte();
        obra.setAutor("adir sodré");
        obra.setTitulo("caminho de são francisco");
        obra.setProcedencia("museu da caixa d'agua");
        obra.setTipo("quadro");
        obra.setDataObra(parseData("25/11/1988"));
        obra.setTecnica("oleo sobre tela");
        obra.setDimensoes("154cm x 154cm");
        
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(obra);
            tx.commit();
            em.close();
            factory.close();
            
}

private static Calendar parseData(String data){
    try{
          Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    } catch (ParseException ex) {
      throw new IllegalArgumentException(ex);
    }
    }
}
    

