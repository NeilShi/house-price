package houseprice.nonentity.result;

import houseprice.nonentity.vo.CommunityInfoVo;

import java.util.List;

public class SearchCommunityInfoResult extends BaseResult{
    private List<CommunityInfoVo> communityInfoVoList;

    public List<CommunityInfoVo> getCommunityInfoVoList() {
        return communityInfoVoList;
    }

    public void setCommunityInfoVoList(List<CommunityInfoVo> communityInfoVoList) {
        this.communityInfoVoList = communityInfoVoList;
    }
}
