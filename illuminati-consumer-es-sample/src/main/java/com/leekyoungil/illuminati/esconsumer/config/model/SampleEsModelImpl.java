package com.leekyoungil.illuminati.esconsumer.config.model;

import com.leekyoungil.illuminati.client.prossor.util.StringUtils;
import com.leekyoungil.illuminati.elasticsearch.infra.EsDocument;
import com.leekyoungil.illuminati.elasticsearch.infra.enums.EsIndexStoreType;
import com.leekyoungil.illuminati.elasticsearch.infra.enums.EsRefreshType;
import com.leekyoungil.illuminati.elasticsearch.model.IlluminatiEsModelImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EsDocument(indexName = "sample-illuminati", type = "log", indexStoreType = EsIndexStoreType.FS, shards = 1, replicas = 0, refreshType = EsRefreshType.TRUE)
public class SampleEsModelImpl extends IlluminatiEsModelImpl {

    private static final long serialVersionUID = 7526472295622776147L;
    private final static Logger SAMPLE_ES_CONSUMER_LOGGER = LoggerFactory.getLogger(SampleEsModelImpl.class);

    public SampleEsModelImpl() {}

    public void customData () {
        this.general.setCustomForEnv();
        this.header.parsingCookie();
    }

    public String getMethodName () {
        if (this.general != null && StringUtils.isValid(this.general.getMethodName())) {
            return this.general.getMethodName();
        }

        return null;
    }

    private void setCustomParsingCookie (String key, String value) {
        if (this.header != null) {
            this.header.setParsedCookieElement(key, value);
        } else {
            SAMPLE_ES_CONSUMER_LOGGER.info("Sorry. header object is null. have to init of header object.");
        }
    }
}
