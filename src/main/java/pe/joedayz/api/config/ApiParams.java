package pe.joedayz.api.config;

import pe.joedayz.api.domain.model.entities.Parameter;
import pe.joedayz.api.enums.YesNoEnum;
import pe.joedayz.api.service.intf.ParamService;

public enum ApiParams {

    NOTIFICATION_SUPPORT_EMAIL("notification.supportEmail", "campus@joedayz.pe", "Support team's email."),
    NOTIFICATION_EMAIL_REPLY_TO("notification.replyTo", "campus@joedayz.pe", "Email reply-to used for email notifications"),
    NOTIFICATION_EMAIL_FROM("notification.from", "campus@joedayz.pe", "Email sender used for email notifications"),
    ;

    String code;
    String value;
    String description;

    ApiParams(String code, Object value, String description) {
        this.code = code;
        this.value = value.toString();
        this.description = description;
    }
    public String asString(ParamService paramService) {
        String valueStr = loadParam(paramService);
        return valueStr;
    }

    public long asLong(ParamService paramService) {
        String valueStr = loadParam(paramService);
        return Long.parseLong(valueStr);
    }
    public boolean asBool(ParamService paramService) {
        String valueStr = loadParam(paramService);

        YesNoEnum yesNoEnum = YesNoEnum.findByCode(valueStr);
        return yesNoEnum!=null && yesNoEnum.asBool();
    }

    private String loadParam(ParamService paramService) {
        Parameter parameter = paramService.getByCode(code);
        if (parameter == null)
            return value;
        else
            return parameter.getValue();
    }
}
