package zhipai_ganme;

public class PKP implements Comparable<PKP> {
	public String Pcolor;
	public String Pvalue;
	public Integer Prank;
	
	public PKP (String value, String color, Integer rank) {
		this.Pvalue = value;
		this.Pcolor = color;
		this.Prank = rank;
	}
	
	 @Override

	 public String toString() {

	 // TODO Auto-generated method stub

	 return Pcolor+Pvalue;

	 }
	 
	//ͨ��rank�÷ֱȽ�ÿ���÷�
	@Override
	public int compareTo(PKP arg0) {
		// TODO �Զ����ɵķ������
		return this.Prank.compareTo(arg0.Prank);
	}
	
}
