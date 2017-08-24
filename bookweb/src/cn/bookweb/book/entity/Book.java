package cn.bookweb.book.entity;

import java.sql.Date;

/**
 * 图书实现类
 * @author tang
 *
 */
public class Book {

	private int bid;//图书编号
	private String bname;//图书名称
	private String author;//图书作者
	private double price;//定价
	private double currprice;//当前价
	private double discount;//折扣
	private String press;//出版社
	private String publishtime;//出版时间
	private int edition;//版次
	private int pagenum;//页数
	private int wordnum;//字数
	private String printtime;//印刷时间
	private int booksize;//开本
	private String paper;//纸质
	private String tid;//所属分类
	private String imagebig;//大图路径
	private String imagesmall;//小图路径
	private String selectone;//大类型
	private String selecttwo;//大类型
	private int stock;//库存
	private String bigtid;//大类型
	
	
	public String getBigtid() {
		return bigtid;
	}

	public void setBigtid(String bigtid) {
		this.bigtid = bigtid;
	}

	/**
	 * 获取库存
	 * @return 库存
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * 指定库存
	 * @param stock 库存
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * 获取上下架
	 * @return 上下架
	 */
	public int getHlframe() {
		return hlframe;
	}

	/**
	 * 指定上下架
	 * @param hlframe 上下架
	 */
	public void setHlframe(int hlframe) {
		this.hlframe = hlframe;
	}

	private int hlframe;//上下架
	
	/**
	 * 小类型
	 * @return 获取大小
	 */
	public String getSelecttwo() {
		return selecttwo;
	}
	
	/**
	 * 指定小类型
	 * @param selectone 小类型
	 */
	public void setSelecttwo(String selecttwo) {
		this.selecttwo = selecttwo;
	}
	
	
	/**
	 * 大类型
	 * @return 获取大类型
	 */
	public String getSelectone() {
		return selectone;
	}
	
	/**
	 * 指定大类型
	 * @param selectone 大类型
	 */
	public void setSelectone(String selectone) {
		this.selectone = selectone;
	}
	
	/**
	 * 获取图书编号
	 * @return 图书编号 bid
	 */
	public int getBid() {
		return bid;
	}
	
	/**
	 * 指定图书编号
	 * @param bid 图书编号
	 */
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	/**
	 * 获取图书名称
	 * @return 图书名称 bname
	 */
	public String getBname() {
		return bname;
	}
	
	/**
	 * 指定图书名称
	 * @param bname 图书名称
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	/**
	 * 获取图书作者
	 * @return 图书作者 author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * 指定图书作者
	 * @param author 图书作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * 获取图书定价
	 * @return 图书定价 price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * 指定图书定价
	 * @param price 图书定价
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * 获取图书当前价
	 * @return 图书当前价 surrprice
	 */
	public double getCurrprice() {
		return currprice;
	}
	
	/**
	 * 指定图书当前价
	 * @param currprice 图书当前价
	 */
	public void setCurrprice(double currprice) {
		this.currprice = currprice;
	}
	
	/**
	 * 获取图书折扣
	 * @return 图书折扣 discount
	 */
	public double getDiscount() {
		return discount;
	}
	
	/**
	 * 指定图书折扣
	 * @param discount 图书折扣
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	/**
	 * 获取图书出版社
	 * @return 图书出版社 press
	 */
	public String getPress() {
		return press;
	}
	
	/**
	 * 指定图书出版社
	 * @param press 图书出版社
	 */
	public void setPress(String press) {
		this.press = press;
	}
	
	/**
	 * 获取图书出版时间
	 * @return 图书出版时间
	 */
	public String getPublishtime() {
		return publishtime;
	}
	
	/**
	 * 指定图书出版时间
	 * @param publishtime 出版时间
	 */
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	
	/**
	 * 获取图书版次
	 * @return 图书版次 edition
	 */
	public int getEdition() {
		return edition;
	}
	
	/**
	 * 指定图书版次
	 * @param edition 图书版次
	 */
	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	/**
	 * 获取图书页数
	 * @return 图书页数 pagenum
	 */
	public int getPagenum() {
		return pagenum;
	}
	
	/**
	 * 指定图书页数
	 * @param pagenum 图书页数
	 */
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	
	/**
	 * 获取图书字数
	 * @return 图书字数 wordnum
	 */
	public int getWordnum() {
		return wordnum;
	}
	
	/**
	 * 指定图书字数
	 * @param wordnum 图书字数
	 */
	public void setWordnum(int wordnum) {
		this.wordnum = wordnum;
	}
	
	/**
	 * 获取图书印刷时间
	 * @return 图书印刷时间 printtime
	 */
	public String getPrinttime() {
		return printtime;
	}
	
	/**
	 * 指定印刷时间
	 * @param printtime 印刷时间
	 */
	public void setPrinttime(String printtime) {
		this.printtime = printtime;
	}
	
	/**
	 * 获取图书开本
	 * @return 图书开本 booksize
	 */
	public int getBooksize() {
		return booksize;
	}
	/**
	 * 指定开本
	 * @param booksize 开本
	 */
	public void setBooksize(int booksize) {
		this.booksize = booksize;
	}
	
	/**
	 * 获取图书纸质
	 * @return 图书纸质 paper
	 */
	public String getPaper() {
		return paper;
	}
	/**
	 * 指定纸质
	 * @param paper 纸质
	 */
	public void setPaper(String paper) {
		this.paper = paper;
	}
	
	/**
	 * 获取图书所属分类
	 * @return 图书所属分类
	 */
	public String getTid() {
		return tid;
	}
	/**
	 * 指定所属分类tid
	 * @param tid 所有分类tid
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}
	
	/**
	 * 获取图书大图路径
	 * @return 图书大图路径 imagebig
	 */
	public String getImagebig() {
		return imagebig;
	}
	
	/**
	 * 指定大图路径
	 * @param imagebig 大图路径
	 */
	public void setImagebig(String imagebig) {
		this.imagebig = imagebig;
	}
	
	/**
	 * 获取图书小图路径
	 * @return 图书小呼路径
	 */
	public String getImagesmall() {
		return imagesmall;
	}
	
	/**
	 * 指定小图路径
	 * @param imagesmall 小图路径
	 */
	public void setImagesmall(String imagesmall) {
		this.imagesmall = imagesmall;
	}
	
	
	private String imagesmall1;//小图路径
	private String imagesmall2;//小图路径
	private String imagesmall3;//小图路径
	private String imagesmall4;//小图路径
	private String imagesmall5;//小图路径
	private String imagesmall6;//小图路径
	private String imagesmall0;//小图路径
	private int bid0;//图书编号
	private int bid1;//图书编号
	private int bid2;//图书编号
	private int bid3;//图书编号
	private int bid4;//图书编号
	private int bid5;//图书编号
	private int bid6;//图书编号
	
	public int getBid0() {
		return bid0;
	}

	public void setBid0(int bid0) {
		this.bid0 = bid0;
	}

	public int getBid1() {
		return bid1;
	}

	public void setBid1(int bid1) {
		this.bid1 = bid1;
	}

	public int getBid2() {
		return bid2;
	}

	public void setBid2(int bid2) {
		this.bid2 = bid2;
	}

	public int getBid3() {
		return bid3;
	}

	public void setBid3(int bid3) {
		this.bid3 = bid3;
	}

	public int getBid4() {
		return bid4;
	}

	public void setBid4(int bid4) {
		this.bid4 = bid4;
	}

	public int getBid5() {
		return bid5;
	}

	public void setBid5(int bid5) {
		this.bid5 = bid5;
	}

	public int getBid6() {
		return bid6;
	}

	public void setBid6(int bid6) {
		this.bid6 = bid6;
	}

	public String getImagesmall1() {
		return imagesmall1;
	}

	public void setImagesmall1(String imagesmall1) {
		this.imagesmall1 = imagesmall1;
	}

	public String getImagesmall2() {
		return imagesmall2;
	}

	public void setImagesmall2(String imagesmall2) {
		this.imagesmall2 = imagesmall2;
	}

	public String getImagesmall3() {
		return imagesmall3;
	}

	public void setImagesmall3(String imagesmall3) {
		this.imagesmall3 = imagesmall3;
	}

	public String getImagesmall4() {
		return imagesmall4;
	}

	public void setImagesmall4(String imagesmall4) {
		this.imagesmall4 = imagesmall4;
	}

	public String getImagesmall5() {
		return imagesmall5;
	}

	public void setImagesmall5(String imagesmall5) {
		this.imagesmall5 = imagesmall5;
	}

	public String getImagesmall6() {
		return imagesmall6;
	}

	public void setImagesmall6(String imagesmall6) {
		this.imagesmall6 = imagesmall6;
	}

	public String getImagesmall0() {
		return imagesmall0;
	}

	public void setImagesmall0(String imagesmall0) {
		this.imagesmall0 = imagesmall0;
	}

	
}
