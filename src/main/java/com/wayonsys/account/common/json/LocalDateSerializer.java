package com.wayonsys.account.common.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.wayonsys.account.common.utils.DateUtils;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @Author: allen
 * @Description:
 * @Date: created in 2018/11/13 16:20
 * @Modified By:
 */
public class LocalDateSerializer extends StdSerializer<LocalDate> {

    public LocalDateSerializer() {
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator generator, SerializerProvider provider)
            throws IOException {
        generator.writeString(DateUtils.DEFAULT_DATE_FORMAT);
    }
}
