package zhipai_ganme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Test_pkp {
	public List<PKP> ls =new ArrayList<PKP>();//�����˿����б�
	public List <Plays> wanjia_list = new ArrayList<Plays>();//��������б�
	Plays p1;
	Plays p2;
	
	//�����˿�����Դ����
	public void shengcheng_pkp() {
		System.out.println("------�����˿���-----------");
		Integer count = 0;
	    String[] CardType = new String[] {"����","÷��","����","����"};  //˳�򲻿ɵ����������Ӱ���С�Ƚϵ�rankֵ
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
	
	//��ȡ��������������Ϣ   
	public void shengcheng_plays() {
		
        Scanner console=new Scanner(System.in);
        System.out.println("�������һλ��ҵ�ID��������");
        
        int id1 = 0;
        String name1;
        //�쳣������ڵ�һ��id���
        while(true){
	        try {
		        System.out.println("������ID");
		        id1=console.nextInt();
		        break;
	        } catch(InputMismatchException e){
				System.out.println("�����������������");
				//e.printStackTrace();
				System.out.println("����������ID");
				console.next();
				}
        }
        //�����һ��ѧ������
	    System.out.println("������������");
	    name1=console.next();
	    p1 = new Plays(id1, name1);
	    wanjia_list.add(p1);
        
        
        System.out.println("������ڶ�λ��ҵ�ID��������");
        System.out.println("������ID");
        int id2=console.nextInt(); 
        System.out.println("������������");
        String name2=console.next();
        p2 = new Plays(id2, name2);
        wanjia_list.add(p2);
        
        for (Plays py : wanjia_list) {
			System.out.println("��ӭ���" + py.name);
		}
//        System.out.println("��ӭ��ң�"+p1.name); 
//        System.out.println("��ӭ��ң�"+p2.name); 
     }
	
	//ʵ��ϴ�ƹ���
	public void xipai() {
		System.out.println("");
		System.out.println("------��ʼϴ��------");
		Collections.shuffle(ls);
		System.out.println("------ϴ�ƽ���--------");
	}

	//ʵ�ַ��ƹ���
	public void fapai() {
	    System.out.println("---------��ʼ����------------"); 
        p1.Pcards.add(ls.get(0));
        System.out.println("----��ң�"+p1.name+"-����------");
        p2.Pcards.add(ls.get(1));
        System.out.println("----��ң�"+p2.name+"-����------");
        p1.Pcards.add(ls.get(2));
        System.out.println("----��ң�"+p1.name+"-����------");
        p2.Pcards.add(ls.get(3));
        System.out.println("----��ң�"+p2.name+"-����------");
        System.out.println("---------���ƽ���------------"); 
	}
	
	//�Ƚ���λ��ҵ�����ƵĴ�С
	public void daxiao() {
		Collections.sort(p1.Pcards);
		Collections.sort(p2.Pcards);
		PKP p1max = p1.Pcards.get(1);    
	    PKP p2max = p2.Pcards.get(1);
	    System.out.println(p1.name+"�������ƣ�"+p1max.Pcolor+p1max.Pvalue);   //������1���������
	    System.out.println(p2.name+"�������ƣ�"+p2max.Pcolor+p2max.Pvalue);   //������2���������
	    if(p1max.Prank>p2max.Prank)
	        {  System.out.println("-----���"+p1.name+"��ʤ��-------");  }
	    else    
	        {  System.out.println("-----���"+p2.name+"��ʤ��--------");  }
	    //�����Ҹ��Ե�����
	    System.out.println("-------��Ҹ��Ե�����Ϊ��----------");
	    PKP p1min=p1.Pcards.get(0);
	    PKP p2min=p2.Pcards.get(0);
	    //��ӡ������Ҹ������ϵ�������
	    System.out.println(p1.name+":"+p1max.Pcolor+p1max.Pvalue+","+p1min.Pcolor+p1min.Pvalue);
	    System.out.println(p2.name+":"+p2max.Pcolor+p2max.Pvalue+","+p2min.Pcolor+p2min.Pvalue);
	    System.out.println("--------��Ϸ����-----------");          
	}
	
	
	
	//������
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test_pkp test1 = new Test_pkp();
		test1.shengcheng_pkp();
		test1.shengcheng_plays();
		test1.xipai();
		test1.fapai();
		test1.daxiao();
		
		
		
	}

}
