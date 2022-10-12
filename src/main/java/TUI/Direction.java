package TUI;

public class Direction {
   String up = "⬆" + direction.UP;
   String down = "⬇" + direction.DOWN;

   enum direction {
      UP,DOWN;

      public char[] repeat(int count) {
         return new char[0];
      }
   }

   public StringBuilder underLine(){

      StringBuilder s = new StringBuilder(" ");
      s.append("⁃".repeat(8));
      s.append(" ".repeat(2));
      s.append("⁃".repeat(70));

      return s;
   }
}
