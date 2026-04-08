public class TerminalRenderer {

    public TerminalRenderer(){

    }

    public void clear(){
        System.out.println("\\033[2J\\033[H"); //ANSI Command to clear console
        System.out.flush();
    }

    public void render(String content){
        System.out.print("\033[H");
        System.out.print(content);
        System.out.flush();
    }
}

