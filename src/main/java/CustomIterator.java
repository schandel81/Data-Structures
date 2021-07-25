import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomIterator{
    public static void main(String[] args)   {
        List<String> str1 = new ArrayList<String>();
        str1.add("12345");
        str1.add("678910");
      Iterator<String>  itr = str1.iterator();
      while(itr.hasNext()) {
          System.out.println(itr.next());
      }
      String [][] arr = {{"1","2","3","7"},{"4","5","6","7"}};
      Iterator<String> arr31 = Arrays.stream(arr).flatMap(Arrays::stream).iterator();
      int[] intarr = {1,2,3};
      List<Integer> l1 = Arrays.stream(intarr).boxed().collect(Collectors.toList());
      while(arr31.hasNext())
          System.out.println(arr31.next());
      /*Iterator<Integer> arrItr = new Iterator<Integer>() {
          int rows = arr.length;
          int cols = arr[0].length;
          int curR = 0;
          int curC = 0;
          @Override
          public boolean hasNext() {
              if(curR >= rows && curC >= cols)
                  return false;
              if(curR < rows && curC >= cols) {
                  curR++;
                  curC = 0;
              }
              return true;
          }
          @Override
          public Integer next() {
              int a = arr[curR][curC++];
              if(curC >= cols)
                  curR++;

          }
      };
      //while(arrItr.hasNext())
          //System.out.println(arrItr.next()); */

    }
}
