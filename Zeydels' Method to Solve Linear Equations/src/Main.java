import java.io.FileReader;

public class Main {
    public static void main(String...args)
    {
        double[][] B = new double[3][3]; //матрица B
        B[0][0]=  0;          B[0][1]= 0.5 ;        B[0][2]= 0 ;
        B[1][0]= 0.5 ;        B[1][1]= 0 ;          B[1][2]= 0.5 ;
        B[2][0]= 0 ;          B[2][1]= 0.5 ;        B[2][2]= 0 ;

        double[] b = new double[3];//вектор свободных членов b
        b[0]=0.16666666;
        b[1]=0.5;
        b[2]=-0.1666666;

        double[] previousX=new double[3];
        previousX[0]=0.16666666;
        previousX[1]=0.5;
        previousX[2]=-0.1666666;
        double[]currentX =new double[3];
        currentX[2]=currentX[1]=currentX[0]=0;
        double epsilon = 0.0005;//наш эпсилон - точность вычисления
        final int amount=3;//количество неизвестных
        int iterations=0;//счетчик итераций

        while(!epsilonIsReached(previousX,currentX,epsilon))//цикл: пока мы не достигли точности в епсилон
        //epsilonIsReached это функция, реализация которой представлена ниже,мы выйдем из цикла как только
        //она нам сообщит, что точность вычисления достигнута
        {
            for(int i=0;i<amount;i++)//в этом вложенном цикле мы вычисляем произведением матриц B и x и добавляем матрицу b
            {
               previousX[i]= currentX[i]; //с каждой последующей итерацией текущее значение вычисленной переменной
                //станет предыдущим в текущей итерации
               currentX[i]=0; //обнулили текущее, сейчас будем его вычислять

                for(int j=i;j<amount;j++)// в этом цикле происходит вычисление Xi, мы умножаем строку матриы B
                    //на столбец [x1,x2,x3] уже известный
                {
                    currentX[i]+=B[i][j]*previousX[j];
                }
                currentX[i]+=b[i];//и добавляем свобоДный член
                for(int j=0;j<i;j++) //в этом цикле мы учитываем ранее вычиленные значения , т е например для
                //неизвестного X3 мы будем учитывать уже вычисленное в текущей итерации X1 и X2
                    //что позволит уменьшить нам количество итераций
                {
                    currentX[i]+=B[i][j]*currentX[j];
                }

            }

            iterations++;
        }
        System.out.println(" Current\n  x1 " +currentX[0]);
        System.out.println("x2 " +currentX[1]);
        System.out.println("x3 " +currentX[2]);
        System.out.println(" Previous \n x1 " +previousX[0]);
        System.out.println("x2 " +previousX[1]);
        System.out.println("x3 " +previousX[2]);
        System.out.println("Iterations : "+iterations);


    }
    public static boolean epsilonIsReached(double[]prevX,double[] curX,double epsilon)
    {

        return (Math.abs(prevX[0] - curX[0])<epsilon&&
                Math.abs(prevX[1] - curX[1])<epsilon&&
                Math.abs(prevX[2] - curX[2])<epsilon) ? true : false;
        //эта функция нам сообщит, когда разность между каждым текущим и предыдующим
        //значением вектора X(x1,x2,x3) будет по модулю меньше эпсилон, то есть когда
        // |x1-x1*<e|, |x2-x2*<e|, |x3-x3*<e|
    }
}
