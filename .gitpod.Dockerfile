FROM gitpod/workspace-full

RUN curl -s "https://get.sdkman.io" | bash \
&& bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install java 24.zulu && sdk default java 24.zulu"

RUN echo 'source "$HOME/.sdkman/bin/sdkman-init.sh"' >> ~/.bashrc