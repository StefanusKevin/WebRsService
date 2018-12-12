/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Klinik;
import pojos.Location;
import util.RskuHibernateUtil;

/**
 *
 * @author userr
 */
public class KlinikHelper {
     public KlinikHelper(){
       
   }
   public List<Klinik> getKlinik(){
       Session session = util.RskuHibernateUtil.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       List<Klinik> hasil = null;
       Query q = session.createQuery("from Klinik");
       hasil = q.list();
       tx.commit();
       session.close();
       return hasil;
   }
   public static String toJson(){
       KlinikHelper helper = new KlinikHelper();
       List<Klinik> list = helper.getKlinik();
       String result = "[";
       for (int i = 0; i < list.size(); i++) {
           if (i < (list.size() - 1)) {
               result += list.get(i).toJson() + ", \n";
           } else {
               result += list.get(i).toJson();
           }

       }
       result+="]";
       return result;
   }

    public void addNewKlinik(String idKlinik, String nama,String spesialis) {
       Session session = RskuHibernateUtil.getSessionFactory().openSession();
       Transaction transaction = session.beginTransaction();
       Klinik klinik = new Klinik(idKlinik, nama, spesialis);
       session.saveOrUpdate(klinik);
       transaction.commit();
       session.close();
   }
}
