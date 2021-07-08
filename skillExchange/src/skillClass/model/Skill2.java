package skillClass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skill2")
public class Skill2 {
	private String TypeCN;
	private int TypeCTR;
	
	public Skill2() {
	} 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getTypeCN() {
		return TypeCN;
	}
	public void setTypeCN(String typeCN) {
		TypeCN = typeCN;
	}
	public int getTypeCTR() {
		return TypeCTR;
	}
	public void setTypeCTR(int typeCTR) {
		TypeCTR = typeCTR;
	}
	
}
