import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Program

{

    public static void main(String[] args) throws Exception

    {



        byte[] key={(byte)0xAC,(byte)0xEC,(byte)0xDF,(byte)0x57};

        FileInputStream input = new FileInputStream("/Users/fnozoszzt/Desktop/3063a897294487c09d87b1599be9e95e.kgtemp");

        {

            FileOutputStream output = new FileOutputStream("test.mp3");

            System.out.println(input.read(new byte[1024], 0, 1024));
            //input(1024, SeekOrigin.Begin);//跳过1024字节的包头

            byte[] buffer = new byte[key.length];

            int length;

            while((length=input.read(buffer,0,buffer.length))>0)


            {


                

                for(int i=0;i<length;i++)

                {

                    byte k = key[i];

                    byte kh = (byte) (k >> 4);

                    byte kl = (byte) (k & 0xf);

                    byte b = buffer[i];

                    byte low = (byte) (b & 0xf ^ kl);//解密后的低4位

                    byte high = (byte) ((b >> 4) ^ kh ^ low & 0xf);//解密后的高4位

                    buffer[i] = (byte)(high << 4 | low);

                }

                output.write(buffer, 0, length);

            }
            output.flush();
            output.close();

        }

    }

}


