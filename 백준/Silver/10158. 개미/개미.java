import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int currentX = (P + T) % (2 * W);
        int currentY = (Q + T) % (2 * H);
        if (currentX > W) currentX = 2 * W - currentX;
        if (currentY > H) currentY = 2 * H - currentY;

        bw.write(currentX + " " + currentY);
        bw.flush();
        bw.close();
    }
}