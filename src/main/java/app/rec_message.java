/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Terfa
 */
public class rec_message {
    private int message_id;
    private String message_number_m, message_date,message_letter_attachments,message_type,message_subject,message_source,message_is_urgent,message_send_method,message_sender,message_reciver,message_state;
    
    public rec_message(int message_id, String message_number_m,String message_date,String message_letter_attachments,String message_type,String message_subject,String message_source, String message_is_urgent,String message_send_method,String message_sender,String message_reciver,String message_state){
        this.message_id = message_id;
        this.message_number_m = message_number_m;
        this.message_date = message_date;
        this.message_letter_attachments = message_letter_attachments;
        this.message_type = message_type;
        this.message_subject = message_subject;
        this.message_source=message_source;
        this.message_is_urgent = message_is_urgent;
        this.message_send_method = message_send_method;
        this.message_sender = message_sender;
        this.message_reciver = message_reciver;
        this.message_state = message_state;
    }
    public int getmessage_id(){
   return message_id;
   }
   
   public String getmessage_number_m(){
   return message_number_m;
   }
   
   public String getmessage_date(){
   return message_date;
   }
   
   public String getmessage_letter_attachments(){
   return message_letter_attachments;
   }
   
   public String getmessage_type(){
   return message_type;
   }
   
   public String getmessage_subject(){
   return message_subject;
   }
   
   public String getmessage_source(){
   return message_source;
   }
   
   public String getmessage_is_urgent(){
   return message_is_urgent;
   }
   
   public String getmessage_send_method(){
   return message_send_method;
   }
   
   public String getmessage_sender(){
   return message_sender;
   }
   
   public String getmessage_reciver(){
   return message_reciver;
   }
   
   public String getmessage_state(){
   return message_state;
   }
   
}
