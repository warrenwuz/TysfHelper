package org.wuzhe.tysfhelper.hanlder.weixin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wuzhe.tysfhelper.pojo.ClassroomInteraction;
import org.wuzhe.tysfhelper.pojo.ClassroomInterationRecord;
import org.wuzhe.tysfhelper.pojo.WxStudent;
import org.wuzhe.tysfhelper.service.IClassroomInteractionService;
import org.wuzhe.tysfhelper.service.IClassroomInterationRecordService;
import org.wuzhe.tysfhelper.service.IWxStudentService;
import org.wuzhe.tysfhelper.utils.AddressApi;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

import javax.annotation.Resource;

@Repository
public class ScanHanler  implements WxMessageHandler {
    @Resource
    private IWxStudentService studentService;
    @Resource
    private IClassroomInterationRecordService classroomInterationRecordService;
	//主机地址
	private static final String address = AddressApi.Address;
	@Override
	public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService)
			throws WxErrorException {
        String openid = wxMessage.getFromUserName();
        String linkStr = "";
        WxXmlOutMessage xmlOutMsg = null;
        WxStudent wxStudent=judgeAuthorization(openid);
        if (wxStudent!=null) {
            List<ClassroomInterationRecord> classroomInterationRecordList = classroomInterationRecordService
                    .queryClassroomInterationRecord(new ClassroomInterationRecord(wxMessage.getEventKey(),true));
            Boolean isExist=judgeIsExist(classroomInterationRecordList,wxStudent.getCid());
            if(isExist){
                WxXmlOutMessage wxXmlOutMessage=WxXmlOutMessage.TEXT().
                        content("<a href='"+address+"/TysfHelper/wx/doClassroomInteraction.do?ciid="+wxMessage.getEventKey()+"'>点击进入课堂互动</a>").toUser(wxMessage.getFromUserName())
                        .fromUser(wxMessage.getToUserName()).build();
                return wxXmlOutMessage;
            }else {
                WxXmlOutMessage wxXmlOutMessage=WxXmlOutMessage.TEXT().
                        content("你不是该课堂互动的学生").toUser(wxMessage.getFromUserName())
                        .fromUser(wxMessage.getToUserName()).build();
                return wxXmlOutMessage;
            }
        }
        linkStr += "<a href='"+address+"/TysfHelper/bindWxSystem.do?openid="+openid+"'>点击绑定教务系统</a>";
        xmlOutMsg = WxXmlOutMessage.TEXT().content("你还未绑定教务系统"+linkStr).toUser(wxMessage.getFromUserName())
                .fromUser(wxMessage.getToUserName()).build();
        return xmlOutMsg;
	}
    /**
     * 用户身份判断
     *
     * @param openid
     * @return
     */
    public WxStudent judgeAuthorization(String openid) {
        WxStudent wxStduent = studentService.selectWxStduent(openid);
        if (wxStduent != null) {
            return wxStduent;
        }
        return null;
    }
    public Boolean judgeIsExist( List<ClassroomInterationRecord> classroomInterationRecordList,String cid){
        List<String> cidList=new ArrayList<>();
        for(ClassroomInterationRecord classroomInterationRecord:classroomInterationRecordList){
            cidList.add(classroomInterationRecord.getCiid());
        }
        if(cidList.contains(cid)){//判断这个学生在不在该互动班级里面
            return true;
        }
        return  false;
    }
}
