package org.wuzhe.tysfhelper.controller.thread;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.bean.TemplateSender;
import com.soecode.wxtools.exception.WxErrorException;

public class TemplateSenderThread extends Thread {
	private IService iService;
	private TemplateSender sender;

	public TemplateSenderThread(IService iService, TemplateSender sender) {
		super();
		this.iService = iService;
		this.sender = sender;
	}

	@Override
	public void run() {
        try {
			iService.templateSend(sender);
		} catch (WxErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
