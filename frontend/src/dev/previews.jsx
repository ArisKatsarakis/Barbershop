import React from 'react'
import {ComponentPreview, Previews} from '@react-buddy/ide-toolbox'
import {PaletteTree} from './palette'
import {RendevouzTable} from "../Components/RendevouzTable";

const ComponentPreviews = () => {
    return (
        <Previews palette={<PaletteTree/>}>
            <ComponentPreview path="/RendevouzTable">
                <RendevouzTable/>
            </ComponentPreview>
        </Previews>
    )
}

export default ComponentPreviews