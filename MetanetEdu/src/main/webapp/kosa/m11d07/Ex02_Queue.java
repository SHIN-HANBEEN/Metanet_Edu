package kr.or.kosa.m11d07;

import java.util.LinkedList;
import java.util.Queue;

class Message {
    String command;
    String to;

    Message(String command, String to) {
        this.command = command;
        this.to = to;
    }
}
public class Ex02_Queue {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();
        /*
            선입 선출 구조를 갖는 Queue.
         */
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "김유신"));
        messageQueue.offer(new Message("sendKakaotalk", "이순신"));

        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();
            switch (message.command) {
                case "sendMail" :
                    System.out.println(message.to + " 메일 전송");
                    break;
                case "sendSMS" :
                    System.out.println(message.to + " 메시지 전송");
                    break;
                case "sendKakaotalk" :
                    System.out.println(message.to + " 카카오톡 전송");
                    break;
            }
        }
    }
}
