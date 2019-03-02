public class array{
   public static void main(String[]args){
   
      int [][] num= new int[4][3];
      int sum = 0;
      for(int i=0; i<num.length; i++){
         for(int j=0; j<num[i].length; j++){
            num[i][j] = (int) (Math.random()*101);
            sum += num[i][j];
            System.out.println(num[i][j] + ",");
         }
      }
      System.out.println(sum);
      boolean isZero = false;
      for(int i=0; i<num.length; i++){
         for(int j=0; j<num[i].length; j++){
            if(num[i][j] == 0){
              for(int a =0; a<num[i].length; a++){
                num[i][a] = 0;
                }
                for(int d = 0; d<num.length; d++){
                num[d][j] = 0;
                }
            }   
         }
      }
    }
  }

