package cn.wj.magic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class OschinaBlogPageProcesser implements PageProcessor {

	private Site site = Site.me().setDomain("www.ganji.com");

	public void process(Page page) {
		// List<String> links = page
		// .getHtml()
		// .links()
		// .regex("http://ganji.com/pincheshangxiaban/_%E5%8C%97%E4%BA%AC-%E6%B0%B8%E5%9F%8E%E5%B8%82/\\d+")
		// .all();
		// page.addTargetRequests(links);
		// page.putField("title", page.getHtml().$("title").toString());
		// page.putField("content",
		// page.getHtml().$("div.layoutlist").toString());
		// page.putField("tags", page.getHtml().$("a.infor-title").all());
		// page.putField("href",
		// page.getHtml().$("a.infor-title").links().all());
		page.addTargetRequests(page.getHtml().$("a.infor-title").links().all());
		page.putField("telephone", page.getHtml().$("div.basic-info-w").all());
		// page.putField("imgpath",
		// page.getHtml().$("img[align=\"absmiddle\"]").all());
		page.putField("imgpath", site.getDomain() + page.getHtml().xpath("//img/@src").toString());
	}

	public Site getSite() {
		site.setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36");
		return site;

	}

	public static void main(String[] args) {
		Spider.create(new OschinaBlogPageProcesser())
				.addUrl("http://ganji.com/pincheshangxiaban/_%E5%8C%97%E4%BA%AC-%E6%B0%B8%E5%9F%8E%E5%B8%82/")
				.addPipeline(new ConsolePipeline()).run();
	}
}