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

    /**
     * Fields to be saved to JWT token.
     */
    private Map<String, Object> fields;

    /**
     * Subject of JWT token.
     */
    private String subject;

    /**
     * Time when token was issued.
     */
    private Date issuedAt;

    /**
     * Time when token will be expired.
     */
    private Date expiredAt;

    /**
     * Default builder.
     *
     * @param subject   subject of JWT token.
     * @param expiredAt JWT token expiration time
     * @return builder
     */
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

        /**
         * Sets field of claims.
         *
         * @param field field name of claims for JWT token
         * @param value field value of claims for JWT token
         * @return builder
         */
        public TokenParametersBuilder field(
                final String field,
                final Object value
        ) {
            this.fields.put(field, value);
            return this;
        }

        /**
         * Sets fields of claims field.
         *
         * @param fields fields of claims
         * @return builder
         */
        public TokenParametersBuilder fields(
                final Map<String, Object> fields
        ) {
            this.fields = fields;
            return this;
        }

        /**
         * Sets subject field.
         *
         * @param subject subject
         * @return builder
         */
        public TokenParametersBuilder subject(
                final String subject
        ) {
            this.subject = subject;
            return this;
        }

        /**
         * Sets issuedAt field.
         *
         * @param issuedAt issuedAt
         * @return builder
         */
        public TokenParametersBuilder issuedAt(
                final Date issuedAt
        ) {
            this.issuedAt = issuedAt;
            return this;
        }

        /**
         * Sets expiredAt field.
         *
         * @param expiredAt expiredAt
         * @return builder
         */
        public TokenParametersBuilder expiredAt(
                final Date expiredAt
        ) {
            this.expiredAt = expiredAt;
            return this;
        }

        /**
         * Builds object.
         *
         * @return built object
         */
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
