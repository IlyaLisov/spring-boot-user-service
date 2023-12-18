package io.github.ilyalisov.springbootuserservice.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Builder(
        builderMethodName = "hiddenBuilder",
        access = AccessLevel.PRIVATE
)
@Getter
public final class TokenParameters {

    private Map<String, Object> fields;
    private String subject;
    private Date issuedAt;
    private Date expiredAt;

    public static TokenParametersBuilder builder(
            final String subject,
            final Date expiredAt
    ) {
        return hiddenBuilder()
                .fields(new HashMap<>())
                .issuedAt(new Date())
                .subject(subject)
                .expiredAt(expiredAt);
    }

    public static class TokenParametersBuilder {

        public TokenParametersBuilder field(
                final String field,
                final Object value
        ) {
            this.fields.put(field, value);
            return this;
        }

        public TokenParametersBuilder fields(
                final Map<String, Object> fields
        ) {
            this.fields = fields;
            return this;
        }

        public TokenParametersBuilder subject(
                final String subject
        ) {
            this.subject = subject;
            return this;
        }

        public TokenParametersBuilder issuedAt(
                final Date issuedAt
        ) {
            this.issuedAt = issuedAt;
            return this;
        }

        public TokenParametersBuilder expiredAt(
                final Date expiredAt
        ) {
            this.expiredAt = expiredAt;
            return this;
        }

        public TokenParameters build() {
            return new TokenParameters(
                    fields,
                    subject,
                    issuedAt,
                    expiredAt
            );
        }

    }

}
