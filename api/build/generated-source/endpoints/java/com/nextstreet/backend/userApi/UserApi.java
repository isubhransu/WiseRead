/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-08-03 17:34:38 UTC)
 * on 2015-10-11 at 18:53:02 UTC 
 * Modify at your own risk.
 */

package com.nextstreet.backend.userApi;

/**
 * Service definition for UserApi (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link UserApiRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class UserApi extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.20.0 of the userApi library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myApplicationId.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "userApi/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public UserApi(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  UserApi(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * An accessor for creating requests from the UserEndpoint collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code UserApi userApi = new UserApi(...);}
   *   {@code UserApi.UserEndpoint.List request = userApi.userEndpoint().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public UserEndpoint userEndpoint() {
    return new UserEndpoint();
  }

  /**
   * The "userEndpoint" collection of methods.
   */
  public class UserEndpoint {

    /**
     * Create a request for the method "userEndpoint.initdb".
     *
     * This request holds the parameters needed by the userApi server.  After setting any optional
     * parameters, call the {@link Initdb#execute()} method to invoke the remote operation.
     *
     * @return the request
     */
    public Initdb initdb() throws java.io.IOException {
      Initdb result = new Initdb();
      initialize(result);
      return result;
    }

    public class Initdb extends UserApiRequest<Void> {

      private static final String REST_PATH = "initdb";

      /**
       * Create a request for the method "userEndpoint.initdb".
       *
       * This request holds the parameters needed by the the userApi server.  After setting any optional
       * parameters, call the {@link Initdb#execute()} method to invoke the remote operation. <p> {@link
       * Initdb#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
       * be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @since 1.13
       */
      protected Initdb() {
        super(UserApi.this, "POST", REST_PATH, null, Void.class);
      }

      @Override
      public Initdb setAlt(java.lang.String alt) {
        return (Initdb) super.setAlt(alt);
      }

      @Override
      public Initdb setFields(java.lang.String fields) {
        return (Initdb) super.setFields(fields);
      }

      @Override
      public Initdb setKey(java.lang.String key) {
        return (Initdb) super.setKey(key);
      }

      @Override
      public Initdb setOauthToken(java.lang.String oauthToken) {
        return (Initdb) super.setOauthToken(oauthToken);
      }

      @Override
      public Initdb setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (Initdb) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Initdb setQuotaUser(java.lang.String quotaUser) {
        return (Initdb) super.setQuotaUser(quotaUser);
      }

      @Override
      public Initdb setUserIp(java.lang.String userIp) {
        return (Initdb) super.setUserIp(userIp);
      }

      @Override
      public Initdb set(String parameterName, Object value) {
        return (Initdb) super.set(parameterName, value);
      }
    }

  }

  /**
   * Create a request for the method "getIfUserExist".
   *
   * This request holds the parameters needed by the userApi server.  After setting any optional
   * parameters, call the {@link GetIfUserExist#execute()} method to invoke the remote operation.
   *
   * @param email
   * @return the request
   */
  public GetIfUserExist getIfUserExist(java.lang.String email) throws java.io.IOException {
    GetIfUserExist result = new GetIfUserExist(email);
    initialize(result);
    return result;
  }

  public class GetIfUserExist extends UserApiRequest<com.nextstreet.backend.userApi.model.User> {

    private static final String REST_PATH = "user/{Email}";

    /**
     * Create a request for the method "getIfUserExist".
     *
     * This request holds the parameters needed by the the userApi server.  After setting any optional
     * parameters, call the {@link GetIfUserExist#execute()} method to invoke the remote operation.
     * <p> {@link GetIfUserExist#initialize(com.google.api.client.googleapis.services.AbstractGoogleCl
     * ientRequest)} must be called to initialize this instance immediately after invoking the
     * constructor. </p>
     *
     * @param email
     * @since 1.13
     */
    protected GetIfUserExist(java.lang.String email) {
      super(UserApi.this, "GET", REST_PATH, null, com.nextstreet.backend.userApi.model.User.class);
      this.email = com.google.api.client.util.Preconditions.checkNotNull(email, "Required parameter email must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetIfUserExist setAlt(java.lang.String alt) {
      return (GetIfUserExist) super.setAlt(alt);
    }

    @Override
    public GetIfUserExist setFields(java.lang.String fields) {
      return (GetIfUserExist) super.setFields(fields);
    }

    @Override
    public GetIfUserExist setKey(java.lang.String key) {
      return (GetIfUserExist) super.setKey(key);
    }

    @Override
    public GetIfUserExist setOauthToken(java.lang.String oauthToken) {
      return (GetIfUserExist) super.setOauthToken(oauthToken);
    }

    @Override
    public GetIfUserExist setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetIfUserExist) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetIfUserExist setQuotaUser(java.lang.String quotaUser) {
      return (GetIfUserExist) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetIfUserExist setUserIp(java.lang.String userIp) {
      return (GetIfUserExist) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key("Email")
    private java.lang.String email;

    /**

     */
    public java.lang.String getEmail() {
      return email;
    }

    public GetIfUserExist setEmail(java.lang.String email) {
      this.email = email;
      return this;
    }

    @Override
    public GetIfUserExist set(String parameterName, Object value) {
      return (GetIfUserExist) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getUsersName".
   *
   * This request holds the parameters needed by the userApi server.  After setting any optional
   * parameters, call the {@link GetUsersName#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public GetUsersName getUsersName() throws java.io.IOException {
    GetUsersName result = new GetUsersName();
    initialize(result);
    return result;
  }

  public class GetUsersName extends UserApiRequest<com.nextstreet.backend.userApi.model.User> {

    private static final String REST_PATH = "user";

    /**
     * Create a request for the method "getUsersName".
     *
     * This request holds the parameters needed by the the userApi server.  After setting any optional
     * parameters, call the {@link GetUsersName#execute()} method to invoke the remote operation. <p>
     * {@link
     * GetUsersName#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected GetUsersName() {
      super(UserApi.this, "GET", REST_PATH, null, com.nextstreet.backend.userApi.model.User.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetUsersName setAlt(java.lang.String alt) {
      return (GetUsersName) super.setAlt(alt);
    }

    @Override
    public GetUsersName setFields(java.lang.String fields) {
      return (GetUsersName) super.setFields(fields);
    }

    @Override
    public GetUsersName setKey(java.lang.String key) {
      return (GetUsersName) super.setKey(key);
    }

    @Override
    public GetUsersName setOauthToken(java.lang.String oauthToken) {
      return (GetUsersName) super.setOauthToken(oauthToken);
    }

    @Override
    public GetUsersName setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetUsersName) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetUsersName setQuotaUser(java.lang.String quotaUser) {
      return (GetUsersName) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetUsersName setUserIp(java.lang.String userIp) {
      return (GetUsersName) super.setUserIp(userIp);
    }

    @Override
    public GetUsersName set(String parameterName, Object value) {
      return (GetUsersName) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "setDoFollow".
   *
   * This request holds the parameters needed by the userApi server.  After setting any optional
   * parameters, call the {@link SetDoFollow#execute()} method to invoke the remote operation.
   *
   * @param peopleToFollow
   * @param followerUser
   * @return the request
   */
  public SetDoFollow setDoFollow(java.lang.String peopleToFollow, java.lang.String followerUser) throws java.io.IOException {
    SetDoFollow result = new SetDoFollow(peopleToFollow, followerUser);
    initialize(result);
    return result;
  }

  public class SetDoFollow extends UserApiRequest<com.nextstreet.backend.userApi.model.User> {

    private static final String REST_PATH = "setDoFollow/{PeopleToFollow}/{FollowerUser}";

    /**
     * Create a request for the method "setDoFollow".
     *
     * This request holds the parameters needed by the the userApi server.  After setting any optional
     * parameters, call the {@link SetDoFollow#execute()} method to invoke the remote operation. <p>
     * {@link
     * SetDoFollow#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param peopleToFollow
     * @param followerUser
     * @since 1.13
     */
    protected SetDoFollow(java.lang.String peopleToFollow, java.lang.String followerUser) {
      super(UserApi.this, "POST", REST_PATH, null, com.nextstreet.backend.userApi.model.User.class);
      this.peopleToFollow = com.google.api.client.util.Preconditions.checkNotNull(peopleToFollow, "Required parameter peopleToFollow must be specified.");
      this.followerUser = com.google.api.client.util.Preconditions.checkNotNull(followerUser, "Required parameter followerUser must be specified.");
    }

    @Override
    public SetDoFollow setAlt(java.lang.String alt) {
      return (SetDoFollow) super.setAlt(alt);
    }

    @Override
    public SetDoFollow setFields(java.lang.String fields) {
      return (SetDoFollow) super.setFields(fields);
    }

    @Override
    public SetDoFollow setKey(java.lang.String key) {
      return (SetDoFollow) super.setKey(key);
    }

    @Override
    public SetDoFollow setOauthToken(java.lang.String oauthToken) {
      return (SetDoFollow) super.setOauthToken(oauthToken);
    }

    @Override
    public SetDoFollow setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (SetDoFollow) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public SetDoFollow setQuotaUser(java.lang.String quotaUser) {
      return (SetDoFollow) super.setQuotaUser(quotaUser);
    }

    @Override
    public SetDoFollow setUserIp(java.lang.String userIp) {
      return (SetDoFollow) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key("PeopleToFollow")
    private java.lang.String peopleToFollow;

    /**

     */
    public java.lang.String getPeopleToFollow() {
      return peopleToFollow;
    }

    public SetDoFollow setPeopleToFollow(java.lang.String peopleToFollow) {
      this.peopleToFollow = peopleToFollow;
      return this;
    }

    @com.google.api.client.util.Key("FollowerUser")
    private java.lang.String followerUser;

    /**

     */
    public java.lang.String getFollowerUser() {
      return followerUser;
    }

    public SetDoFollow setFollowerUser(java.lang.String followerUser) {
      this.followerUser = followerUser;
      return this;
    }

    @Override
    public SetDoFollow set(String parameterName, Object value) {
      return (SetDoFollow) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "setUser".
   *
   * This request holds the parameters needed by the userApi server.  After setting any optional
   * parameters, call the {@link SetUser#execute()} method to invoke the remote operation.
   *
   * @param username
   * @param password
   * @param firstname
   * @param lastname
   * @param email
   * @return the request
   */
  public SetUser setUser(java.lang.String username, java.lang.String password, java.lang.String firstname, java.lang.String lastname, java.lang.String email) throws java.io.IOException {
    SetUser result = new SetUser(username, password, firstname, lastname, email);
    initialize(result);
    return result;
  }

  public class SetUser extends UserApiRequest<com.nextstreet.backend.userApi.model.User> {

    private static final String REST_PATH = "setUser/{Username}/{Password}/{Firstname}/{Lastname}/{Email}";

    /**
     * Create a request for the method "setUser".
     *
     * This request holds the parameters needed by the the userApi server.  After setting any optional
     * parameters, call the {@link SetUser#execute()} method to invoke the remote operation. <p>
     * {@link
     * SetUser#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
     * be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param username
     * @param password
     * @param firstname
     * @param lastname
     * @param email
     * @since 1.13
     */
    protected SetUser(java.lang.String username, java.lang.String password, java.lang.String firstname, java.lang.String lastname, java.lang.String email) {
      super(UserApi.this, "POST", REST_PATH, null, com.nextstreet.backend.userApi.model.User.class);
      this.username = com.google.api.client.util.Preconditions.checkNotNull(username, "Required parameter username must be specified.");
      this.password = com.google.api.client.util.Preconditions.checkNotNull(password, "Required parameter password must be specified.");
      this.firstname = com.google.api.client.util.Preconditions.checkNotNull(firstname, "Required parameter firstname must be specified.");
      this.lastname = com.google.api.client.util.Preconditions.checkNotNull(lastname, "Required parameter lastname must be specified.");
      this.email = com.google.api.client.util.Preconditions.checkNotNull(email, "Required parameter email must be specified.");
    }

    @Override
    public SetUser setAlt(java.lang.String alt) {
      return (SetUser) super.setAlt(alt);
    }

    @Override
    public SetUser setFields(java.lang.String fields) {
      return (SetUser) super.setFields(fields);
    }

    @Override
    public SetUser setKey(java.lang.String key) {
      return (SetUser) super.setKey(key);
    }

    @Override
    public SetUser setOauthToken(java.lang.String oauthToken) {
      return (SetUser) super.setOauthToken(oauthToken);
    }

    @Override
    public SetUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (SetUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public SetUser setQuotaUser(java.lang.String quotaUser) {
      return (SetUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public SetUser setUserIp(java.lang.String userIp) {
      return (SetUser) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key("Username")
    private java.lang.String username;

    /**

     */
    public java.lang.String getUsername() {
      return username;
    }

    public SetUser setUsername(java.lang.String username) {
      this.username = username;
      return this;
    }

    @com.google.api.client.util.Key("Password")
    private java.lang.String password;

    /**

     */
    public java.lang.String getPassword() {
      return password;
    }

    public SetUser setPassword(java.lang.String password) {
      this.password = password;
      return this;
    }

    @com.google.api.client.util.Key("Firstname")
    private java.lang.String firstname;

    /**

     */
    public java.lang.String getFirstname() {
      return firstname;
    }

    public SetUser setFirstname(java.lang.String firstname) {
      this.firstname = firstname;
      return this;
    }

    @com.google.api.client.util.Key("Lastname")
    private java.lang.String lastname;

    /**

     */
    public java.lang.String getLastname() {
      return lastname;
    }

    public SetUser setLastname(java.lang.String lastname) {
      this.lastname = lastname;
      return this;
    }

    @com.google.api.client.util.Key("Email")
    private java.lang.String email;

    /**

     */
    public java.lang.String getEmail() {
      return email;
    }

    public SetUser setEmail(java.lang.String email) {
      this.email = email;
      return this;
    }

    @Override
    public SetUser set(String parameterName, Object value) {
      return (SetUser) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link UserApi}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link UserApi}. */
    @Override
    public UserApi build() {
      return new UserApi(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link UserApiRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setUserApiRequestInitializer(
        UserApiRequestInitializer userapiRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(userapiRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
