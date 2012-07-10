package org.sdu.android.map.action;

import org.sdu.android.sprite.AbstractSprite;


/**
 * 
 * @author Joycery & Sww
 *进行碰撞的精灵组
 */
public class CollisionGroup {

	/**碰撞精灵其一*/
	AbstractSprite sp1;
	
	/**碰撞精灵其二*/
	AbstractSprite sp2;

	/**
	 * 
	 * @param sp1 碰撞精灵其一
	 * @param sp2 碰撞精灵其二
	 */
	public CollisionGroup(AbstractSprite sp1, AbstractSprite sp2) {
		super();
		this.sp1 = sp1;
		this.sp2 = sp2;
	}

	/**
	 * 
	 * @return 碰撞精灵其一
	 */
	public AbstractSprite getSp1() {
		return sp1;
	}

	/**
	 * 
	 * @return 碰撞精灵其二
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
	 * 判断两个对象是否相同
	 * @param groupB  另一个精灵组
	 * @return 是否相同
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
