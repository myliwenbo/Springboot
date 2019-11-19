/**
 * 
 */
package vip.xjdai.common.domain;

import lombok.Data;

/**
 * @author lwb
 * 统一出参
 */
@Data
public class ResponseBean {

    private String errorMessage;

    public ResponseBean(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

}
