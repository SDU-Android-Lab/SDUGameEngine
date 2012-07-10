package org.sdu.android.map.action;

import org.sdu.android.sprite.AbstractSprite;


/**
 * 
 * @author Joycery & Sww
 *������ײ�ľ�����
 */
public class CollisionGroup {

	/**��ײ������һ*/
	AbstractSprite sp1;
	
	/**��ײ�������*/
	AbstractSprite sp2;

	/**
	 * 
	 * @param sp1 ��ײ������һ
	 * @param sp2 ��ײ�������
	 */
	public CollisionGroup(AbstractSprite sp1, AbstractSprite sp2) {
		super();
		this.sp1 = sp1;
		this.sp2 = sp2;
	}

	/**
	 * 
	 * @return ��ײ������һ
	 */
	public AbstractSprite getSp1() {
		return sp1;
	}

	/**
	 * 
	 * @return ��ײ�������
	 */
	public AbstractSprite getSp2() {
		return sp2;
	}

	/**
	 * @return skgjjsdfg
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sp1 == null) ? 0 : sp1.hashCode());
		result = prime * result + ((sp2 == null) ? 0 : sp2.hashCode());
		return result;
	}

	/**
	 * @return dfldskjlgj
	 * @param obj dsf
	 */
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final CollisionGroup other = (CollisionGroup) obj;
		if(this.sp1==other.getSp1()&&this.sp2==other.getSp2())
			{
				return true;
			}
			if(this.sp1==other.getSp2()&&this.sp2==other.getSp1())
			{
				return true;
			}
				return false;
	}
	
	/**
	 * �ж����������Ƿ���ͬ
	 * @param groupB  ��һ��������
	 * @return �Ƿ���ͬ
	 */
//	public boolean equals(CollisionGroup groupB)
//	{
//		if(this.sp1==groupB.getSp1()&&this.sp2==groupB.getSp2())
//		{
//			return true;
//		}
//		if(this.sp1==groupB.getSp2()&&this.sp2==groupB.getSp1())
//		{
//			return true;
//		}
//			return false;
//	}
}
