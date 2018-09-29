package zhipai_ganme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Test_pkp {
	public List<PKP> ls =new ArrayList<PKP>();//创建扑克牌列表
	public List <Plays> wanjia_list = new ArrayList<Plays>();//创建玩家列表
	Plays p1;
	Plays p2;
	
	//创建扑克牌资源数组
	public void shengcheng_pkp() {
		System.out.println("------生成扑克牌-----------");
		Integer count = 0;
	    String[] CardType = new String[] {"方块","梅花","红桃","黑桃"};  //顺序不可调换，否则会影响大小比较的rank值
	    String[] CardNum = new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	    for(int i = 0; i < 13; i++) {
	    	for (int j = 0; j < 4; j++) {
	    		ls.add( new PKP(CardNum[i], CardType[j],count++) );
	    	}
	    }
	    for (PKP pkp : ls) {
			System.out.print(pkp+", ");
		}
	}
	
	//获取输入的两名玩家信息   
	public void shengcheng_plays() {
		
        Scanner console=new Scanner(System.in);
        System.out.println("请输入第一位玩家的ID和姓名：");
        
        int id1 = 0;
        String name1;
        //异常检测用于第一个id检测
        while(true){
	        try {
		        System.out.println("请输入ID");
		        id1=console.nextInt();
		        break;
	        } catch(InputMismatchException e){
				System.out.println("输入错误，请重新输入");
				//e.printStackTrace();
				System.out.println("请重新输入ID");
				console.next();
				}
        }
        //输入第一个学生姓名
	    System.out.println("请输入姓名：");
	    name1=console.next();
	    p1 = new Plays(id1, name1);
	    wanjia_list.add(p1);
        
        
        System.out.println("请输入第二位玩家的ID和姓名：");
        System.out.println("请输入ID");
        int id2=console.nextInt(); 
        System.out.println("请输入姓名：");
        String name2=console.next();
        p2 = new Plays(id2, name2);
        wanjia_list.add(p2);
        
        for (Plays py : wanjia_list) {
			System.out.println("欢迎玩家" + py.name);
		}
//        System.out.println("欢迎玩家："+p1.name); 
//        System.out.println("欢迎玩家："+p2.name); 
     }
	
	//实现洗牌功能
	public void xipai() {
		System.out.println("");
		System.out.println("------开始洗牌------");
		Collections.shuffle(ls);
		System.out.println("------洗牌结束--------");
	}

	//实现发牌功能
	public void fapai() {
	    System.out.println("---------开始发牌------------"); 
        p1.Pcards.add(ls.get(0));
        System.out.println("----玩家："+p1.name+"-拿牌------");
        p2.Pcards.add(ls.get(1));
        System.out.println("----玩家："+p2.name+"-拿牌------");
        p1.Pcards.add(ls.get(2));
        System.out.println("----玩家："+p1.name+"-拿牌------");
        p2.Pcards.add(ls.get(3));
        System.out.println("----玩家："+p2.name+"-拿牌------");
        System.out.println("---------发牌结束------------"); 
	}
	
	//比较两位玩家的最大牌的大小
	public void daxiao() {
		Collections.sort(p1.Pcards);
		Collections.sort(p2.Pcards);
		PKP p1max = p1.Pcards.get(1);    
	    PKP p2max = p2.Pcards.get(1);
	    System.out.println(p1.name+"最大的手牌："+p1max.Pcolor+p1max.Pvalue);   //输出玩家1的最大手牌
	    System.out.println(p2.name+"最大的手牌："+p2max.Pcolor+p2max.Pvalue);   //输出玩家2的最大手牌
	    if(p1max.Prank>p2max.Prank)
	        {  System.out.println("-----玩家"+p1.name+"获胜！-------");  }
	    else    
	        {  System.out.println("-----玩家"+p2.name+"获胜！--------");  }
	    //输出玩家各自的手牌
	    System.out.println("-------玩家各自的手牌为：----------");
	    PKP p1min=p1.Pcards.get(0);
	    PKP p2min=p2.Pcards.get(0);
	    //打印两名玩家各自手上的两张牌
	    System.out.println(p1.name+":"+p1max.Pcolor+p1max.Pvalue+","+p1min.Pcolor+p1min.Pvalue);
	    System.out.println(p2.name+":"+p2max.Pcolor+p2max.Pvalue+","+p2min.Pcolor+p2min.Pvalue);
	    System.out.println("--------游戏结束-----------");          
	}
	
	
	
	//主函数
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test_pkp test1 = new Test_pkp();
		test1.shengcheng_pkp();
		test1.shengcheng_plays();
		test1.xipai();
		test1.fapai();
		test1.daxiao();
		
		
		
	}

}
