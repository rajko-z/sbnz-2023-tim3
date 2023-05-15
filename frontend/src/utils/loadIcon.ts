import {library} from '@fortawesome/fontawesome-svg-core';
import * as Icons from '@fortawesome/free-solid-svg-icons';
import {
    IconDefinition,
    IconPrefix,
    IconPack
} from "@fortawesome/free-solid-svg-icons";

const loadIcon = () => {
    type IconDefinitionOrPack = IconDefinition | IconPack;

    interface ImportedIcons {
        [key: string]: IconPrefix | IconDefinitionOrPack;
    }

    const iconList = Object
        .keys(Icons)
        .filter(key => key !== "fas" && key !== "prefix")
        .map(icon => (Icons as ImportedIcons)[icon]);

    library.add(...(iconList as IconDefinitionOrPack[]));
};
export default loadIcon;