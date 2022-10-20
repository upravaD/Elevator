package UI;

public class Direction {
   String up = "⬆" + direction.UP;
   String down = "⬇" + direction.DOWN;

   enum direction {
      UP,DOWN
   }

   public StringBuilder underLine(){
      StringBuilder s = new StringBuilder(" ");
      s.append("⁃".repeat(8));
      s.append(" ".repeat(2));
      s.append("⁃".repeat(80));

      return s;
   }
}
