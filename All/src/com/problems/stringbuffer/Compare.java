package src.com.problems.stringbuffer;
class Compare{
    public static void main(String[] args) {
        StringBuffer sf=new StringBuffer();
        StringBuilder sb=new StringBuilder();
        long startTime=0,endTime=0;
        int end=(int)1e6;
        startTime=System.nanoTime();
        for(int i=0; i<end; i++){
            sf.append("Hey ! : ");
        }
        endTime=System.nanoTime();
        long sft=endTime-startTime;
        System.out.println("time taked by stringbuffer : " +(sft));
        startTime=System.nanoTime();
        for(int i=0; i<end; i++){
            sb.append("Hey ! : ");
        }
        endTime=System.nanoTime();
        long sbt=endTime-startTime;
        System.out.println("time taked by stringbuilder : " +(sbt));
        if(sft<sbt){
            System.out.println("stringbuffer takes less time : ");
        }else if(sft>sbt){
            System.out.println("stringbuilder takes less time : ");
        }else{
            System.out.println("both takes equals time : ");
        }

    }
}