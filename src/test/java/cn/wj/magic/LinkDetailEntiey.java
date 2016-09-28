/**
 * className:LinkDetailEntiey.java<br/>
 * @since 2016年9月28日 上午10:34:53
 * @aouthor eagle
 */
package cn.wj.magic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author Administrator
 *
 */
public class LinkDetailEntiey implements PageProcessor {
	private Site site = Site.me().setDomain("ganji.com/pincheshangxiaban");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * us.codecraft.webmagic.processor.PageProcessor#process(us.codecraft.webmagic
	 * .Page)
	 */
	public void process(Page page) {
		page.putField("title", page.getHtml().$("title").toString());
		page.putField("content", page.getHtml().$("div.layoutlist").toString());
		page.putField("tags", page.getHtml().$("a.infor-title").all());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#getSite()
	 */
	public Site getSite() {
		return site;
	}

}
