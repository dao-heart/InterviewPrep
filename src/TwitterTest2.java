import java.io.*;
import static java.lang.String.format;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwitterTest2 {
    public static void main(String[] args)  throws Exception {
        // String line = "10.10.10.10 - - [27/Sep/2016:05:22:00 +0000] \"GET /1.1/friendships/list.json?XXXXX HTTP/1.1\" 500 563 19 \"Twitter-iPhone/6.63 iOS/10.0.2 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177";
        LL myLL = new LL();
        String responseCodeCopy = "";
        int responseCodeAsNumber;
        Pattern a = Pattern.compile("(\\[(?<time>.*)\\])?");
        Pattern responseCodeString = Pattern.compile("\"\\s+(?<resCode>[0-9]{0,3})\\s+");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line1;
        String myString = null;
        String newLine;

        while (((line1 = bufferedReader.readLine()) != null) && (line1.length() != 0)) {
            myString = line1;
            try{
                String[] firstSplit = myString.split(" - - ");
                String rest1 = firstSplit[1];

                String time = null;
                Matcher m1 = a.matcher(rest1);
                if (m1.find()) {
                    time = m1.group("time");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm", Locale.ENGLISH);
                    Date d1 = null;
                    d1 = sdf.parse(time);
                    String timeAsString = sdf.format(d1);
                    long totalTime = d1.getTime();
                    String[] endPointCopy = rest1.split("\"");
                    String rest2 = endPointCopy[1];
                    String[] splitByQuestionMark = rest2.split("\\?");
                    String[] split3 = splitByQuestionMark[0].split(" ");
                    String url = split3[1];
                    Matcher responseCodeMatch = responseCodeString.matcher(myString);
                    if (responseCodeMatch.find()) {
                        responseCodeCopy = responseCodeMatch.group("resCode").trim();
                    }
                    responseCodeAsNumber = Integer.parseInt(responseCodeCopy);
                    newLine = timeAsString + " " + url;

                    if (responseCodeAsNumber >= 500) {
                        myLL.sortedInsert(newLine, d1, url, false);
                    } else {
                        myLL.sortedInsert(newLine, d1, url, true);
                    }

                }

            }catch(Exception e){
                System.out.println(line1);
                e.printStackTrace();
            }

        }

        myLL.printList();
    }
}


class LL {

    public Node head;

    public LL() {
        this.head = null;
    }

    public void sortedInsert(String text2, Date d, String text3, boolean isHit) {

        Node temp = this.head;
        Node prev = null;
        long totalTimeCopy = d.getTime();

        while ((temp != null) && (temp.compare(totalTimeCopy, text3) < 0)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null) {

            if (prev != null) {
                if (temp.compare(totalTimeCopy, text3) == 0) {

                    if (isHit) {
                        temp.incrementHit();
                    } else {
                        temp.incrementMiss();
                    }

                } else {
                    Node nnode;
                    if (isHit) {
                        nnode = new Node(text2, d, 1, 0, null);
                    } else {
                        nnode = new Node(text2, d, 0, 1, null);
                    }
                    nnode.next = temp;
                    prev.next = nnode;

                }
            } else if (temp.compare(totalTimeCopy, text3) == 0) {

                if (isHit) {
                    temp.incrementHit();
                } else {
                    temp.incrementMiss();
                }

            } else {
                Node nnode;
                if (isHit) {
                    nnode = new Node(text2, d, 1, 0, null);
                } else {
                    nnode = new Node(text2, d, 0, 1, null);
                }

                this.head = nnode;
                nnode.next = temp;

            }

        } else {

            Node nnode;
            if (isHit) {
                nnode = new Node(text2, d, 1, 0, null);
            } else {
                nnode = new Node(text2, d, 0, 1, null);
            }
            if (prev == null) {
                this.head = nnode;
            } else {
                prev.next = nnode;
            }

        }

    }

    public void printList() throws FileNotFoundException {
        Node temp = this.head;

        while (temp != null) {

            int Hit = temp.getHit();
            int Miss = temp.getMiss();
            DecimalFormat f = new DecimalFormat("##.00");
            double sucRate = Hit * 100.0 / (double)(Hit + Miss);

            System.out.println(temp.getTimetext() + " " + temp.getEndpoint() + " " + f.format(sucRate));
            temp = temp.next;
        }

    }

}// end of LL


class Node {

    private String text;
    private int Hit;
    private int Miss;
    public Node next;
    public Date date;

    public Node(String text, Date d, int Hit, int Miss, Node next) {
        this.text = text;
        this.date = d;
        this.Hit = Hit;
        this.Miss = Miss;
        this.next = next;
    }

    public String getText() {
        return this.text;
    }

    public String getEndpoint() {
        // will get url(endpoint)
        String[] splitEndPoint = this.text.split(" ");
        return splitEndPoint[1];
    }

    public long getTime() {
        return this.date.getTime();
    }

    public String getTimetext() {
        Date d = new Date(this.date.getTime());
        SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return print.format(d);
        // return str
    }

    public int getHit() {
        return this.Hit;
    }

    public int getMiss() {
        return this.Miss;
    }

    public void incrementHit() {
        this.Hit = this.Hit + 1;
    }

    public void incrementMiss() {
        this.Miss = this.Miss + 1;
    }

    public int compare(long Time, String Text3) {
        // if other is greater then

        if (this.getTime() < Time) {
            return -1;
        }

        if (this.getTime() > Time) {
            return 1;
        }

        if (this.getTime() == Time) {

            if (this.getEndpoint().compareTo(Text3) > 0) {
                //will return positive if
                return 1;
            }

            if (this.getEndpoint().compareTo(Text3) < 0) {
                return -1;
            }

            if (this.getEndpoint().compareTo(Text3) == 0) {
                return 0;
            }

        }

        return 0;

    }

}
