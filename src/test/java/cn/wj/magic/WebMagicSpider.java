package cn.wj.magic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class WebMagicSpider implements PageProcessor {

	private Site site = Site.me().setDomain("my.oschina.net");

	public void process(Page page) {
		// List<String> links =
		// page.getHtml().links().regex("http://my\\.oschina\\.net/flashsword/blog/\\d+")
		// .all();
		// page.addTargetRequests(links);
		page.putField("title", page.getHtml().$("title").toString());
		page.putField("content", page.getHtml().$("div.content").toString());
		page.putField("tags", page.getHtml().$("div.title").xpath("a").all());
	}

	public Site getSite() {
		return site;

	}

	public static void main(String[] args) {
		Spider.create(new WebMagicSpider()).addUrl("http://my.oschina.net/flashsword/blog")
				.addPipeline(new ConsolePipeline()).run();
	}
}
