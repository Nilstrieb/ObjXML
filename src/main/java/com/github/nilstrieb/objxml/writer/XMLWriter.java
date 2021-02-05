package com.github.nilstrieb.objxml.writer;

import com.github.nilstrieb.objxml.data.Value;

import java.util.stream.Stream;

public class XMLWriter {

    public String writeObject(String className, Stream<Value> valueStream) {
        StringBuilder sb = new StringBuilder();

        sb.append("<").append(className).append(">")
                .append("\n");
        valueStream.forEach(v -> {
            sb.append("\t<").append(v.getName()).append(">").append(v.getValue()).append("</").append(v.getName()).append(">\n");
        });

        sb.append("</").append(className).append(">");

        return sb.toString();
    }
}
