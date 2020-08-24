package scripts.daxCredentials;

import scripts.dax_api.api_lib.DaxWalker;
import scripts.dax_api.api_lib.models.DaxCredentials;
import scripts.dax_api.api_lib.models.DaxCredentialsProvider;

public class setDaxCreds {
    public setDaxCreds() {
        DaxWalker.setCredentials(new DaxCredentialsProvider() {
            @Override
            public DaxCredentials getDaxCredentials() {
                return new DaxCredentials("sub_DPjcfqN4YkIxm8", "sub_DPjXXzL5DeSiPf");
            }
        });
    }
}
