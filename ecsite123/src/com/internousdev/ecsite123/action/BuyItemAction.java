package com.internousdev.ecsite123.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	private int stock;
	private String pay;
	public Map<String,Object>session;
	private String result;

	public String execute(){
		result=SUCCESS;

		session.put("stock", stock);
		int intStock=Integer.parseInt(session.get("stock").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		session.put("buyItem_price",intStock * intPrice);
		String payment;

		if(pay.equals("1")){
			payment="Cash";
			session.put("pay",payment);
		}else{
			payment="Credit";
			session.put("pay",payment);
		}
		return result;
	}
	public int getStock(){
		return stock;
	}

	public void setStock(int stock){
		this.stock=stock;
	}
	public String getPay(){
		return pay;
	}
	public void setPay(String pay){
		this.pay=pay;
	}
	public Map<String,Object>getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

}
