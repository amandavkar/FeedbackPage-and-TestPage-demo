package com.atul.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {
		
		public String name;
		@Id
		public String email;
		public String msg;
		public int reg;
		public String code;
		public int rating;
		
		public Feedback() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Feedback(String name, String email, String message, int reg, String code, int rating) {
			super();
			this.name = name;
			this.email = email;
			this.msg = message;
			this.reg = reg;
			this.code = code;
			this.rating = rating;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public int getReg() {
			return reg;
		}
		public void setReg(int reg) {
			this.reg = reg;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		@Override
		public String toString() {
			return "Feedback [name=" + name + ", email=" + email + ", message=" + msg + ", reg=" + reg + ", code="
					+ code + ", rating=" + rating + "]";
		}

}

